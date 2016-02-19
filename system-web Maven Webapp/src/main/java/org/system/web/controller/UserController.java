package org.system.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.system.service.*;
import org.system.domain.*;

@Controller
@RequestMapping("/user")
public class UserController
{
    private static final Log logger = LogFactory.getLog(UserController.class);
    public static int count = 0;
    @Resource
    private UserService userService;

    @RequestMapping("/testShow")
    public String testShow(HttpServletRequest request, Model model)
    {
        return "showUser";
    }

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model)
    {
        //return "showUser";
        return "forward:/user/showUserAgain"; //测试
        //return "redirect:/user/showUserAgain"; //
    }

    @RequestMapping("/showUserAgain")
    public String showUserAgain(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");
        User user = this.userService.getUser(name);

        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping("/addUser")
    public String addUser(HttpServletRequest request, Model model)
    {
        //执行插入操作
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        userService.addUser(new User(name, age));


        //查询插入结果
        User user = userService.getUser(name);
        model.addAttribute("user", user);

        logger.info(user);
        logger.info("user insert : " + name);
        //logger.warn("test warning", new RuntimeException("test Exception"));
        //logger.error("test ERROR", new RuntimeException("test ERROR"));

        //清除测试数据
        userService.deleteUser(user.getName());
        return "addUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");
        logger.info("user deleting  --> " + name+" <--");

        if(null==name)
        {
            model.addAttribute("msg","user name is NULL !");
            return "error";
        }
        if(userService.getUser(name)==null)
        {
            model.addAttribute("msg"," This user Not exit");
            return "error";
        }

        userService.deleteUser(name);
        logger.info("user delete name : " + name);
        return "success";
    }

    public UserController()
    {
        System.out.println("User controller construct the " + (++count) + " times");
    }
}
