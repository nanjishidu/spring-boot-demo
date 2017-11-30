package com.example.controller.common;
/**
 * 分页结构
 *
 * @author  nanjishiu
 * @version 1.0, 2017/11
 */
public class PageData {
    /**
     * 页数
     */
    private int page;
    /**
     * 总条数
     */
    private int total;
    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int num_page;
    /**
     * 分页数据
     */
    private Object data;
    public PageData(int page,int pageSize,int total,Object data) {
        int num_page = total / pageSize;
        if (total%pageSize > 0) {
            num_page++;
        }
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
        this.num_page = num_page;
        this.data = data;

    }
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNum_page() {
        return num_page;
    }

    public void setNum_page(int num_page) {
        this.num_page = num_page;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
