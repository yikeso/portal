package com.bopinghui.po.documents;

import java.util.Date;
import java.util.Objects;

/**
 * 文章搜索索引
 * @author kakasun
 * @create 2018-02-28 下午2:11
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
     * 文章摘要
     */
    String bstract;
    /**
     * 关键词
     */
    String keywords;
    /**
     * 文章内容
     */
    String content;
    /**
     * 发布日期
     */
    Date publishDate;

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

    public String getBstract() {
        return bstract;
    }

    public void setBstract(String bstract) {
        this.bstract = bstract;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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
                ", bstract='" + bstract + '\'' +
                ", keywords='" + keywords + '\'' +
                ", content='" + content + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
