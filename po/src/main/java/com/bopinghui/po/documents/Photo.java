package com.bopinghui.po.documents;

import java.util.Date;
import java.util.Objects;

/**
 * 图片搜索索引
 * @author kakasun
 * @create 2018-02-28 下午2:11
 */
public class Photo {
    /**
     * id
     */
    String id;
    /**
     * 图片储存路径
     */
    String path;
    /**
     * 图说
     */
    String description;
    /**
     * 图片上传日期
     */
    Date uploadDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(id, photo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id='" + id + '\'' +
                ", path='" + path + '\'' +
                ", description='" + description + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
