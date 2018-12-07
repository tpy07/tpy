package com.tpy.books.service;

import com.tpy.books.model.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    /**
     * 根据销售量排序并且分页查询所有书
     * @param page 当前页
     * @return
     */
    public Object[] querAllByLimt(int page);
    /**
     * 查询最新书籍
     * @return 三条数据
     */
    public List<Books> selectByPioneer();

    /**
     * 根据bid查询书籍信息
     * @param bid
     * @return
     */
    public Books selectByBid(int bid);

    /**
     * 分页查询所有书籍
     * @param page
     * @return
     */
    public Object[] querAll(int page);

    /**
     * 添加书籍
     * @param book
     * @return
     */
    public int addBook(Books book);
}
