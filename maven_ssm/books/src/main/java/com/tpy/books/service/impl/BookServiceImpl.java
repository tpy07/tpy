package com.tpy.books.service.impl;

import com.tpy.books.dao.BookDao;
import com.tpy.books.model.Books;
import com.tpy.books.service.BookService;
import com.tpy.books.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value="bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Object[] querAllByLimt(int page) {
        //该数组用来存储分页查询的内容和分页等信息
        Object[] obj=new Object[3];
        int sum=bookDao.selectSum();
        PageBean pagebean=new PageBean(page,sum,2);
        try {
            List<Books> list=bookDao.querAllByLimt((page-1)*2);
            List<Books> news=bookDao.selectByPioneer();
            obj[0]=list;
            obj[2]=news;
        }catch (Exception e){
            e.printStackTrace();
        }
        obj[1]=pagebean;

        return obj;
    }

    @Override
    public List<Books> selectByPioneer() {
        try {
            List<Books> list=bookDao.selectByPioneer();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Books selectByBid(int bid) {
        try {
            Books book=bookDao.selectByBid(bid);
            return book;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object[] querAll(int page) {
        try {
            List<Books> list=bookDao.querAll((page-1)*12);
            for (Books b:
                 list) {
                System.out.println(b.getBookImage());
            }
            PageBean pagebean=new PageBean(page,bookDao.selectSum(),12);
            Object[] obj=new Object[2];
            obj[0]=list;
            obj[1]=pagebean;
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public int addBook(Books book) {
        try {
            bookDao.addBook(book);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }
}
