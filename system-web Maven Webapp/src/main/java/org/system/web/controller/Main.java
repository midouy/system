package org.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/{index}/test")
	//在路径匹配中加入参数, 这种方式可以让一套后台代码匹配多套前台页面
	public String Test(@PathVariable String index){

		System.out.println("index = " + index);

		return "test";
	}

	public static void main(String[] args)
	{
		System.out.println("Hello world");
	}


}
