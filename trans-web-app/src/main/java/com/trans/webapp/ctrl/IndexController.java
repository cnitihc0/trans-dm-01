package com.trans.webapp.ctrl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author mashaobo
 * @date 17/2/25
 * @blog http://blog.csdn.net/cnitihc0
 * @email cnitihc0@163.com
 */
@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private HttpSession session;

    @RequestMapping(value={"login", "/"}, method=RequestMethod.GET)
    public String login(){
        return "/static/login.html";
    }

}
