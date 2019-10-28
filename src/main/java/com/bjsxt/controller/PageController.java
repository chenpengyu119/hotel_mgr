package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengyu
 * @date 2019/10/18 10:47.
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String showIndex(){
        return "redirect:/room/show";
    }
}
