/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Implementist.iReading;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 供类封装图书的数据库进行操作
 *
 * @author Implementist
 */
public class BookDAO {

    /**
     * 插入Book对象到数据库中
     *
     * @param book 将要插入的Book对象
     * @return 是否成功插入
     */
    public static Boolean insertBook(Book book) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("INSERT INTO book(BookID,PageCount,Score,");
        sqlStatement.append("Title,Author,CoverURL,ContentURL,FileName)");
        sqlStatement.append(" VALUES(?,?,?,?,?,?,?,?)");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, book.getBookID());
            preparedStatement.setInt(2, book.getPageCount());
            preparedStatement.setFloat(3, book.getScore());
            preparedStatement.setString(4, book.getTitle());
            preparedStatement.setString(5, book.getAuthor());
            preparedStatement.setString(6, book.getCoverURL());
            preparedStatement.setString(7, book.getContentURL());
            preparedStatement.setString(8, book.getFileName());

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 查询数据库中所有绘本
     *
     * @return 绘本列表
     */
    public static JSONArray queryAll() {
        JSONArray books = new JSONArray();

        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM book");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                JSONObject book = new JSONObject();
                book.put("BookID", resultSet.getInt("BookID"));
                book.put("PageCount", resultSet.getInt("PageCount"));
                book.put("Score", (float) (resultSet.getInt("TotalScore")
                        / (resultSet.getInt("EvaluatorCount") + 0.0)));
                book.put("Title", resultSet.getString("Title"));
                book.put("Author", resultSet.getString("Author"));
                book.put("CoverURL", resultSet.getString("CoverURL"));
                book.put("ContentURL", resultSet.getString("ContentURL"));
                book.put("FileName", resultSet.getString("FileName"));

                books.add(book);
            }
            return books;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
}
