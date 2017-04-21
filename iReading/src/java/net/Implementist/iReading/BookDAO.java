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
        sqlStatement.append("INSERT INTO book(serialNumber,title,categoryId,");
        sqlStatement.append("contentAdress,author,uploaderId,commentsAdress)");
        sqlStatement.append(" VALUES(?,?,?,?,?,?,?)");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, book.getSerialNumber());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setInt(3, book.getCategoryId());
            preparedStatement.setString(4, book.getContentAdress());
            preparedStatement.setString(5, book.getAuthor());
            preparedStatement.setInt(6, book.getUploaderId());
            preparedStatement.setString(7, book.getCommentsAdress());

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
     * 删除给定编号的绘本
     *
     * @param serialNumber 给定的绘本编号
     * @return 是否成功删除
     */
    public static Boolean deleteBook(int serialNumber) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("DELETE FROM book WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, serialNumber);

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
     * 更改给定编号绘本的标题
     *
     * @param serialNumber 给定的绘本编号
     * @param title 新的标题
     * @return 是否成功更新
     */
    public static Boolean updateTitle(int serialNumber, String title) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE book SET title=?");
        sqlStatement.append(" WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, serialNumber);

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
     * 更改给定编号绘本的类别ID
     *
     * @param serialNumber 给定的绘本编号
     * @param categoryId 新的类别ID
     * @return 是否成功更新
     */
    public static Boolean updateCategoryId(int serialNumber, int categoryId) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE book SET categoryId=?");
        sqlStatement.append(" WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, categoryId);
            preparedStatement.setInt(2, serialNumber);

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
     * 更改给定编号绘本的内容地址
     *
     * @param serialNumber 给定的绘本编号
     * @param contentAdress 新的内容地址
     * @return 是否成功更新
     */
    public static Boolean updateContentAdress(int serialNumber, String contentAdress) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE book SET contentAdress=?");
        sqlStatement.append(" WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, contentAdress);
            preparedStatement.setInt(2, serialNumber);

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
     * 更改给定编号绘本的作者
     *
     * @param serialNumber 给定的绘本编号
     * @param author 新的作者
     * @return 是否成功更新
     */
    public static Boolean updateAuthor(int serialNumber, String author) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE book SET author=?");
        sqlStatement.append(" WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, author);
            preparedStatement.setInt(2, serialNumber);

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
     * 更改给定编号绘本的上传者ID
     *
     * @param serialNumber 给定的绘本编号
     * @param uploaderId 新的上传者ID
     * @return 是否成功更新
     */
    public static Boolean updateUploaderId(int serialNumber, int uploaderId) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE book SET uploaderId=?");
        sqlStatement.append(" WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, uploaderId);
            preparedStatement.setInt(2, serialNumber);

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
     * 更改给定编号绘本的评论文件地址
     *
     * @param serialNumber 给定的绘本编号
     * @param commentsAdress 新的评论文件地址
     * @return 是否成功更新
     */
    public static Boolean updateCommentsAdress(int serialNumber, String commentsAdress) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE book SET commentsAdress=?");
        sqlStatement.append(" WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, commentsAdress);
            preparedStatement.setInt(2, serialNumber);

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
     * 查询给定编号绘本的详细信息
     *
     * @param serialNumber 给定的绘本编号
     * @return 查询到的封装了详细信息的Book对象
     */
    public static Book queryBook(int serialNumber) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM book WHERE serialNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, serialNumber);

            resultSet = preparedStatement.executeQuery();
            Book book = new Book();
            if (resultSet.next()) {
                book.setSerialNumber(resultSet.getInt("serialNumber"));
                book.setTitle(resultSet.getString("title"));
                book.setCategoryId(resultSet.getInt("categoryId"));
                book.setContentAdress(resultSet.getString("contentAdress"));
                book.setAuthor(resultSet.getString("author"));
                book.setUploaderId(resultSet.getInt("uploaderId"));
                book.setCommentsAdress(resultSet.getString("commentsAdress"));
                return book;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
}
