package com.bopinghui.po.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 文章
 *
 * @author kakasun
 * @create 2018-02-28 下午12:52
 */
public class Article {

    /**
     * id
     */
    String id;
    /**
     * 文章标题
     */
    String title;
    /**
     * 作者
     */
    String author;
    /**
     * 关键词
     */
    List<String> keywords;
    /**
     * 栏目id
     */
    int columnId;
    /**
     * 栏目名称
     */
    String columnName;
    /**
     * 是否删除
     */
    boolean delete;
    /**
     * 是否发布
     */
    boolean publish;
    /**
     * 发布日期
     */
    Date publishDate;
    /**
     * 文章创建日期
     */
    Date createDate;
    /**
     * 文章修改日期
     */
    Date updateDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isDelete() {
        return delete;
    }

    public boolean getDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isPublish() {
        return publish;
    }

    public boolean getPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        setUpdateDate(createDate);
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", keywords=" + keywords +
                ", columnId=" + columnId +
                ", columnName='" + columnName + '\'' +
                ", delete=" + delete +
                ", publish=" + publish +
                ", publishDate=" + publishDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
