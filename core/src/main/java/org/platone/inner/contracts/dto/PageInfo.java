package org.platone.inner.contracts.dto;

import java.util.List;

public class PageInfo<T> {
    private int totalCount;
    private int totalPage;
    private int pageNum;
    private List<T> items;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PageInfo [totalCount=" + totalCount + ", totalPage=" + totalPage + ", pageNum=" + pageNum + ", items="
            + items + "]";
    }

}
