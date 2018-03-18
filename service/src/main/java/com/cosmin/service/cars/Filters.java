package com.cosmin.service.cars;

public class Filters {
    private int page;
    private int pageSize = 10;

    public int getPage() {
        return page;
    }

    public Filters setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Filters setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
