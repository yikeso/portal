package com.bopinghui.po.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 文章内容
 *
 * @author kakasun
 * @create 2018-02-28 下午1:20
 */
public class ArticleDetail {
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
     * 商品详情连接
     */
    String detailsLink;
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

    public String getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(String detailsLink) {
        this.detailsLink = detailsLink;
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
        ArticleDetail that = (ArticleDetail) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ArticleDetail{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", detailsLink='" + detailsLink + '\'' +
                ", bstract='" + bstract + '\'' +
                ", keywords='" + keywords + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
