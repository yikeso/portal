package com.bopinghui.portalbackstage.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制层
 *
 * @author kakasun
 * @create 2018-03-01 上午9:14
 */
@Controller
public class RootController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title","网站后台管理系统");
        return "index";
    }
}
