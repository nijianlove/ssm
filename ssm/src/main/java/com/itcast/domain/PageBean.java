package com.itcast.domain;

public class PageBean {

    private Integer counts;//总记录数
    private Integer rows;//每页显示条数
    private Integer totalPages;//总页数
    private Integer startPage;//起始页
    private Integer currentPage;//当前页
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "counts=" + counts +
                ", rows=" + rows +
                ", totalPages=" + totalPages +
                ", startPage=" + startPage +
                ", currentPage=" + currentPage +
                ", user=" + user +
                '}';
    }
}
