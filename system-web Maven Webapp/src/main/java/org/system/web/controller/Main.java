package org.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangyanming on 2015/8/18.
 */
@Controller
@RequestMapping("main")
public class Main
{
    @RequestMapping("mainPage")
    public String showMainPage()
    {
        return "mainPage";
    }

    @RequestMapping("test")
    public String showTest()
    {
        return "test";
    }

}
