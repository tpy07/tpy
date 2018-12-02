package com.tpy.log.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultView {
    @RequestMapping("/")
    public String defaultViews(){
        return "forward:/logs/querAll?pages=1";
    }
}
