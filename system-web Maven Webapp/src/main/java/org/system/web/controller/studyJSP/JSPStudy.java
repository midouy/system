package org.system.web.controller.studyJSP;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangyanming on 2015/8/26.
 *
 *  满足JSP study 的一些访问需求
 *
 */
@Controller
@RequestMapping("/JSP")
public class JSPStudy
{
    private static String CONTEXT = "study/";

    //拦截  [basic | advanced | functions] / JSP_NAME
    @RequestMapping("*")
    public String accessJSP(HttpServletRequest request)
    {
        String jspName = request.getParameter("jspName").trim();
        System.out.println("access JSP :  "+CONTEXT+jspName+".jsp");

        int index = request.getRequestURL().toString().indexOf("JSP")+4;
        String subContext = request.getRequestURL().toString().substring(index);
        
        return CONTEXT+subContext+"/"+jspName;
    }

}
