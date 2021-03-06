package com.bopinghui.po.entity;

import org.springframework.data.annotation.Id;

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
    @Id
    String id;
    /**
     * 文章标题
     */
    String title;
    /**
     * 封面
     */
    List<String> cover;
    /**
     * 作者
     */
    String author;
    /**
     * 关键词
     */
    String keywords;

    /**
     * 栏目id
     */
    Integer columnId;
    /**
     * 栏目名称
     */
    String columnName;
    /**
     * 是否删除
     */
    Boolean delete;
    /**
     * 是否发布
     */
    Boolean publish;
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

    public List<String> getCover() {
        return cover;
    }

    public void setCover(List<String> cover) {
        this.cover = cover;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Boolean isDelete() {
        return delete;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public Boolean isPublish() {
        return publish;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
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
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", keywords='" + keywords + '\'' +
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
