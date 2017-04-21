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
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Implementist
 */
public class UserDAO {

//    public static void main(String[] args){
//        User user = new User();
//        user.setUserName("virtualUser");
//        String securityStamp = Encrypt.getNewSecurityStamp();
//        String ciphertext = Encrypt.getCiphertext("0987654321", securityStamp);
//        user.setPasswordHash(ciphertext);
//        user.setSecurityStamp(securityStamp);
//        UserDAO.insertUserByUserName(user);
//    }
    
    /**
     * 以UserName为键将User对象插入到数据库中
     *
     * @param user 将要插入的User对象
     * @return 是否成功插入
     */
    public static Boolean insertUserByUserName(User user) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("INSERT INTO user(UserName,PasswordHash,SecurityStamp,");
        sqlStatement.append("RegistrationDateTime,LastLoginDateTime)");
        sqlStatement.append(" VALUES(?,?,?,?,?)");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPasswordHash());
            preparedStatement.setString(3, user.getSecurityStamp());

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            preparedStatement.setTimestamp(4, timestamp);
            preparedStatement.setTimestamp(5, timestamp);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 以PhoneNumber为键将User对象插入到数据库中
     *
     * @param user 将要插入的User对象
     * @return 是否成功插入
     */
    public static Boolean insertUserByPhoneNumber(User user) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("INSERT INTO user(PhoneNumber,PhoneNumberVerified,");
        sqlStatement.append("PasswordHash,SecurityStamp,");
        sqlStatement.append("RegistrationDateTime,LastLoginDateTime)");
        sqlStatement.append(" VALUES(?,?,?,?,?,?)");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, user.getPhoneNumber());
            preparedStatement.setBoolean(2, true);
            preparedStatement.setString(3, user.getPasswordHash());
            preparedStatement.setString(4, user.getSecurityStamp());

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            preparedStatement.setTimestamp(5, timestamp);
            preparedStatement.setTimestamp(6, timestamp);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 以EmailAddress为键将User对象插入到数据库中
     *
     * @param user 将要插入的User对象
     * @return 是否成功插入
     */
    public static Boolean insertUserByEmailAddress(User user) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("INSERT INTO user(EmailAddress,EmailAddressVerified,");
        sqlStatement.append("PasswordHash,SecurityStamp,");
        sqlStatement.append("RegistrationDateTime,LastLoginDateTime)");
        sqlStatement.append(" VALUES(?,?,?,?,?,?)");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, user.getEmailAddress());
            preparedStatement.setBoolean(2, true);
            preparedStatement.setString(3, user.getPasswordHash());
            preparedStatement.setString(4, user.getSecurityStamp());

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());

            preparedStatement.setTimestamp(5, timestamp);
            preparedStatement.setTimestamp(6, timestamp);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 删除给定ID的用户
     *
     * @param userID 给定的用户Id
     * @return 是否成功删除
     */
    public static Boolean deleteUser(int userID) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("DELETE FROM user WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 更改给定ID用户的手机号码
     *
     * @param userID 给定的用户Id
     * @param phoneNumber 新的手机号
     * @return 是否成功更新
     */
    public static Boolean updatePhoneNumber(int userID, String phoneNumber) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE user SET PhoneNumber=?");
        sqlStatement.append(" WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setInt(2, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 更改给定ID用户的手机号码是否已验证值
     *
     * @param userID 给定的用户Id
     * @param phoneNumberVerified 新的手机号码是否已验证值
     * @return 是否成功更新
     */
    public static Boolean updatePhoneNumberVerified(int userID, Boolean phoneNumberVerified) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE user SET PhoneNumberVerified=?");
        sqlStatement.append(" WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setBoolean(1, phoneNumberVerified);
            preparedStatement.setInt(2, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 更改给定ID用户的邮箱地址
     *
     * @param userID 给定的用户Id
     * @param emailAddress 新的邮箱地址
     * @return 是否成功更新
     */
    public static Boolean updateEmailAddress(int userID, String emailAddress) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE user SET EmailAddress=?");
        sqlStatement.append(" WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, emailAddress);
            preparedStatement.setInt(2, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 更改给定ID用户的邮箱地址是否已验证值
     *
     * @param userID 给定的用户Id
     * @param emailAddressVerified 新的邮箱地址是否已验证值
     * @return 是否成功更新
     */
    public static Boolean updateEmailAddressVerified(int userID, Boolean emailAddressVerified) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE user SET EmailAddressVerified=?");
        sqlStatement.append(" WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setBoolean(1, emailAddressVerified);
            preparedStatement.setInt(2, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 更改给定ID用户的密码哈希值和安全戳
     *
     * @param userID 给定的用户Id
     * @param passwordHash 新的密码哈希
     * @param securityStamp 新的安全戳
     * @return 是否成功更新
     */
    public static Boolean updatePasswordHashAndSecurityStamp(int userID,
            String passwordHash, String securityStamp) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE user SET PasswordHash=?,SecurityStamp=?");
        sqlStatement.append(" WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, passwordHash);
            preparedStatement.setString(2, securityStamp);
            preparedStatement.setInt(3, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 更改给定ID用户的上次登录时间
     *
     * @param userID 给定的用户Id
     * @param lastLoginDateTime 新的密码哈希
     * @return 是否成功更新
     */
    public static Boolean updateLastLoginDateTime(int userID, Timestamp lastLoginDateTime) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("UPDATE user SET LastLoginDateTime=?");
        sqlStatement.append(" WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setTimestamp(1, lastLoginDateTime);
            preparedStatement.setInt(2, userID);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, null);
        }
    }

    /**
     * 查询给定ID用户的详细信息
     *
     * @param userID 给定的用户ID
     * @return 查询到的封装了详细信息的User对象
     */
    public static User queryUserByID(int userID) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM user WHERE UserID=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setInt(1, userID);

            resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPhoneNumber(resultSet.getString("PhoneNumber"));
                user.setPhoneNumberVerified(resultSet.getBoolean("PhoneNumberVerified"));
                user.setEmailAddress(resultSet.getString("EmailAddress"));
                user.setEmailAddressVerified(resultSet.getBoolean("EmailAddressVerified"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setSecurityStamp(resultSet.getString("SecurityStamp"));
                user.setRegistrationDateTime(resultSet.getTimestamp("RegistrationDateTime"));
                user.setLastLoginDateTime(resultSet.getTimestamp("LastLoginDateTime"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 查询给定用户名用户的详细信息
     *
     * @param userName 给定的用户名
     * @return 查询到的封装了详细信息的User对象
     */
    public static User queryUserByUserName(String userName) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM user WHERE UserName=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, userName);

            resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPhoneNumber(resultSet.getString("PhoneNumber"));
                user.setPhoneNumberVerified(resultSet.getBoolean("PhoneNumberVerified"));
                user.setEmailAddress(resultSet.getString("EmailAddress"));
                user.setEmailAddressVerified(resultSet.getBoolean("EmailAddressVerified"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setSecurityStamp(resultSet.getString("SecurityStamp"));
                user.setRegistrationDateTime(resultSet.getTimestamp("RegistrationDateTime"));
                user.setLastLoginDateTime(resultSet.getTimestamp("LastLoginDateTime"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 查询给定手机号码用户的详细信息
     *
     * @param phoneNumber 给定的手机号码
     * @return 查询到的封装了详细信息的User对象
     */
    public static User queryUserByPhoneNumber(String phoneNumber) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM user WHERE PhoneNumber=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, phoneNumber);

            resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPhoneNumber(resultSet.getString("PhoneNumber"));
                user.setPhoneNumberVerified(resultSet.getBoolean("PhoneNumberVerified"));
                user.setEmailAddress(resultSet.getString("EmailAddress"));
                user.setEmailAddressVerified(resultSet.getBoolean("EmailAddressVerified"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setSecurityStamp(resultSet.getString("SecurityStamp"));
                user.setRegistrationDateTime(resultSet.getTimestamp("RegistrationDateTime"));
                user.setLastLoginDateTime(resultSet.getTimestamp("LastLoginDateTime"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    /**
     * 查询给定邮箱地址用户的详细信息
     *
     * @param emailAddress 给定的邮箱地址
     * @return 查询到的封装了详细信息的User对象
     */
    public static User queryUserByEmailAddress(String emailAddress) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM user WHERE EmailAddress=?");

        //设置数据库的字段值
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, emailAddress);

            resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("UserName"));
                user.setPhoneNumber(resultSet.getString("PhoneNumber"));
                user.setPhoneNumberVerified(resultSet.getBoolean("PhoneNumberVerified"));
                user.setEmailAddress(resultSet.getString("EmailAddress"));
                user.setEmailAddressVerified(resultSet.getBoolean("EmailAddressVerified"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setSecurityStamp(resultSet.getString("SecurityStamp"));
                user.setRegistrationDateTime(resultSet.getTimestamp("RegistrationDateTime"));
                user.setLastLoginDateTime(resultSet.getTimestamp("LastLoginDateTime"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
}
