package com.bee.common;

/**
 * created by guos on 2018/11/10
 */
public class PaginatedResult<T> extends Result<T> {

    private long total;
    private int pageSize;


    public PaginatedResult(int code, T data, long total, int pageSize) {
        super.setCode(code);
        super.setData(data);
        this.total = total;
        this.pageSize = pageSize;
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public static <T> PaginatedResult<T> successfulResponse(T data, long total, int pageSize) {
        return new PaginatedResult<>(200, data, total, pageSize);
    }
}
