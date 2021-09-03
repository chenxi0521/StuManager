package com.offcn.util;

/**
 * @author chenxi
 * @date 2021/8/27 13:41
 * @description
 */
public class PageUtil {

    private int page;
    private int rows;
    private int index;
    private int countRows;
    private int countPage;
    private int prePage;
    private int nextPage;

    public PageUtil(String page,int rows,int countRows){
        this.rows = rows;
        this.countRows = countRows;
        init_page(page);
        init_index();
        init_countPage();
        init_prePage();
        init_nextPage();
    }

    private void init_page(String page){
        if(page==null||"".equals(page)){
            this.page=1;
        }else {
            this.page=Integer.parseInt(page);
        }
    }

    private void  init_index(){
        this.index = (this.page-1)*this.rows;
    }

    private void init_countPage(){
        this.countPage = (int)Math.ceil(this.countRows*1.0/this.rows);
    }

    private void init_prePage(){
        if (this.page <= 1){
            this.prePage = 1;
        }else {
            this.prePage = this.page - 1;
        }
    }

    private void init_nextPage(){
        if (this.page >= this.countPage){
            this.nextPage =  this.countPage;
        }else {
            this.nextPage = this.page + 1;
        }
    }

    public int getPage() {
        return page;
    }

    public int getRows() {
        return rows;
    }

    public int getIndex() {
        return index;
    }

    public int getCountRows() {
        return countRows;
    }

    public int getCountPage() {
        return countPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public int getNextPage() {
        return nextPage;
    }
}
