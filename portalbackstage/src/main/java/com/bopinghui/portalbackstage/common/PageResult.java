package com.bopinghui.portalbackstage.common;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author kakasun
 * @create 2018-03-01 下午8:48
 */
public class PageResult<T> {

    Integer pageNo;
    Integer pageSize;
    Long count;
    List<T> data;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
