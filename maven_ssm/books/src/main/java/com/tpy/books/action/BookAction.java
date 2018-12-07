package com.tpy.books.action;

import com.tpy.books.model.Books;
import com.tpy.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    @RequestMapping("/addBook")
    @ResponseBody
    public int addBook(Books book,@RequestParam(value="file",required=false) MultipartFile file) throws IOException {
        String pathRoot=req.getServletContext().getRealPath("")+"/";
        System.out.println(book.getBookContext());
        if(!file.isEmpty()){//判断文件不为空
            String uuid= UUID.randomUUID().toString();//随机生成UUID ，用作文件名
            String contextType=file.getContentType();//获取上传文件类型（如果不是图片，禁止上传）
            System.out.println("文件类型"+contextType);
//			file.getOriginalFilename();//获取文件名
            String imageName="."+contextType.substring(contextType.indexOf("/")+1);
            System.out.println("文件后缀"+imageName);
            String path="subimage/"+uuid+imageName;
            file.transferTo(new File(pathRoot+path));
            System.out.printf(path);
            book.setBookImage(path);
        }
        int i=bookService.addBook(book);
        return i;
    }
}
