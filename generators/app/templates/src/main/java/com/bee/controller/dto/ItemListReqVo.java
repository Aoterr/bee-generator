package com.bee.controller.dto;

/**
 * created by guos on 2018/11/10
 */
public class ItemListReqVo {
    private String searchTitle;
    private int pageSize = 20;
    private int pageNum;

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
