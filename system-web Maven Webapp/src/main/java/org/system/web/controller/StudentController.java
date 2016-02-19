package org.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.system.domain.Student;
import org.system.service.StudentService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyanming on 2015/9/9.
 */
@Controller
@RequestMapping("/stu")
public class StudentController
{
    @Resource
    private StudentService studentService;

    @RequestMapping("/getStudent")
    public String getStudent(HttpServletRequest request, Model model)
    {
        String name = request.getParameter("name");
        if(null==name)
            return "error";

        Student student = studentService.getStudent(name);
        model.addAttribute("student",student);
        return "showStudent";
    }

}
