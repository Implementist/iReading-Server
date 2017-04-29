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
    private int bookID;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 得分
     */
    private float score;

    /**
     * 绘本标题
     */
    private String title;

    /**
     * 作者姓名
     */
    private String author;

    /**
     * 封面URL
     */
    private String coverURL;

    /**
     * 内容文件地址
     */
    private String contentURL;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 无参数构造函数
     */
    public Book() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(String coverURL) {
        this.coverURL = coverURL;
    }

    public String getContentURL() {
        return contentURL;
    }

    public void setContentURL(String contentURL) {
        this.contentURL = contentURL;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
