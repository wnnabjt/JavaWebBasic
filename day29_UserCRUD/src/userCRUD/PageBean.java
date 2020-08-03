package userCRUD;

import java.util.List;

public class PageBean <T> {

    private int totalCount;
    private int totPage;
    private List<T> list;
    private int currentPage;
    private int rows;

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totPage=" + totPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }

    public int getTotPage() {
        return totPage;
    }

    public void setTotPage(int totPage) {
        this.totPage = totPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
