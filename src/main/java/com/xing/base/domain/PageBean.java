package com.xing.base.domain;

import java.util.List;

/**
 * 分页结果类
 */
public class PageBean<T> {
    /**当前页码*/
    private int pageCode;
    /**总记录数*/
    private int totalRecode;
    /**每页记录数*/
    private int pageSize = 5;
    /**当前页记录数据*/
    private List<T> beanList;
    /**当前页码开始条数*/
    private int start;
    /**url后面的条件*/
    private String url;

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCode=" + pageCode +
                ", totalRecode=" + totalRecode +
                ", pageSize=" + pageSize +
                ", start=" + start +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * 计算总页码数
     * @return
     */
    public int getTotalPage(){
        if((totalRecode%pageSize) == 0){
            return totalRecode/pageSize;
        }
        return totalRecode/pageSize + 1;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public int getTotalRecode() {
        return totalRecode;
    }

    public void setTotalRecode(int totalRecode) {
        this.totalRecode = totalRecode;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
