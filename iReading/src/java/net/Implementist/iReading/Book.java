/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Implementist.iReading;

/**
 *
 * @author Implementist
 */
public class Book {

    /**
     * 绘本编号
     */
    private int serialNumber;

    /**
     * 绘本标题
     */
    private String title;

    /**
     * 类别编码
     */
    private int categoryId;

    /**
     * 内容文件地址
     */
    private String contentAdress;

    /**
     * 作者姓名
     */
    private String author;

    /**
     * 上传者ID
     */
    private int uploaderId;

    /**
     * 评论文件地址
     */
    private String commentsAdress;

    /**
     * 无参数构造函数
     */
    public Book() {
    }

    /**
     * 六参数构造函数 默认上传者为系统
     *
     * @param serialNumber
     * @param title
     * @param categoryId
     * @param contentAdress
     * @param author
     * @param commentAdress
     */
    public Book(int serialNumber, String title, int categoryId,
            String contentAdress, String author, String commentAdress) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.categoryId = categoryId;
        this.contentAdress = contentAdress;
        this.author = author;
        this.uploaderId = 1;
        this.commentsAdress = commentAdress;
    }

    /**
     * 全参数构造函数
     *
     * @param serialNumber
     * @param title
     * @param categoryId
     * @param contentAdress
     * @param author
     * @param uploaderId
     * @param commentAdress
     */
    public Book(int serialNumber, String title, int categoryId,
            String contentAdress, String author, int uploaderId,
            String commentAdress) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.categoryId = categoryId;
        this.contentAdress = contentAdress;
        this.author = author;
        this.uploaderId = uploaderId;
        this.commentsAdress = commentAdress;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getContentAdress() {
        return contentAdress;
    }

    public void setContentAdress(String contentAdress) {
        this.contentAdress = contentAdress;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getCommentsAdress() {
        return commentsAdress;
    }

    public void setCommentsAdress(String commentsAdress) {
        this.commentsAdress = commentsAdress;
    }
}
