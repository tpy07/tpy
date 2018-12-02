package com.tpy.books.action;

import com.tpy.books.model.Books;
import com.tpy.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
@RequestMapping("/book")
public class BookAction {
    @Autowired
    private BookService bookService;
    @Resource
    private HttpServletRequest req;
    @RequestMapping("/querAll")
    public String querAllByLimt(Integer page){
       Object[] objects=bookService.querAllByLimt(page);
        req.setAttribute("list",objects);
        return "index";
    }
    @RequestMapping("/selectByBid")
    public String selectByBid(int bid){
        Books book=bookService.selectByBid(bid);
        req.setAttribute("book",book);
        return "details";
    }
    @RequestMapping("/all")
    public String querAll(int page){
        Object[] objects=bookService.querAll(page);
        req.setAttribute("list",objects);
        return "category";
    }
}
