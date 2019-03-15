package com.tpy.log.action;

import com.tpy.log.model.Logs;
import com.tpy.log.service.LogsService;
import com.tpy.log.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/logs")
public class LogsAction {
    @Autowired
    private LogsService logsService;
    @Resource
    private HttpSession session;
    @Resource
    private HttpServletRequest req;
    private String context;
    @RequestMapping("/querAll")
    public String querAll(@RequestParam(value = "pages",defaultValue = "1") Integer pages){
        List<Logs> list =logsService.querAll(pages);
        PageBean page= new PageBean(list,pages,logsService.selectBySum(null),3);
        req.setAttribute("logs",list);
        req.setAttribute("testpage",page);
        req.setAttribute("type",0);
        return "index";
    }
    @RequestMapping("/selectByBname")
    public String selectByBname(@RequestParam(value = "pages",defaultValue = "1") Integer pages,@RequestParam(value = "context") String context){
        if(context.equals("")||context==null){
            if(this.context==null&&"".equals(this.context)){
                return "index";
            }
        }else{
            this.context=context;
        }
        Logs logs=new Logs();
        logs.setBname(this.context);
        logs.setBcontext(this.context);
        List<Logs> list=logsService.selectByBname(logs,pages);
        PageBean page= new PageBean(null,pages,logsService.selectBySum(logs),3);
        req.setAttribute("logs",list);
        req.setAttribute("testpage",page);
        req.setAttribute("type",1);
        req.setAttribute("context", context);
        return "index";
    }
    @RequestMapping(value = "/addLogs",method = RequestMethod.POST)
    @ResponseBody
    public int addLogs(Logs logs,HttpServletRequest request,@RequestParam("files") MultipartFile file){
        String userName=session.getAttribute("uname").toString();
     /*   if (multipartRequest.isEmpty()) {
            return -2;
        }*/                System.out.println(file.getOriginalFilename());
        try {
          /*  for (MultipartFile file:filelist){
            }*/
   /*         logs.setFilePath(fileName);
            //获取跟目录
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            if(!path.exists()) path = new File("");
            System.out.println("path:"+path.getAbsolutePath());
            File dest = new File(path.getAbsolutePath()+ "/upload/image/" + fileName);
            multipartRequest.transferTo(dest);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        logs.setUserName(userName);
        logs.setClickRcte("0");
        int i=logsService.addlogs(logs);
        return i;
    }
    @RequestMapping("addBug.html")
    public String pageAddBug(){
        return "addBug";
    }
    @RequestMapping("/selectByBid")
    public String selectByBid(Logs log){
        Logs logs=logsService.selectByBid(log);
        req.setAttribute("xxnr",logs);
        return "license";
    }
    @RequestMapping("/deleteBugs")
    @ResponseBody
    public int delete(Logs logs){
        int i=logsService.delete(logs);
        return i;
    }
}
