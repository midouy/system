package org.system.web.controller.studyJSP;

import bit.wym.commons.date.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //拦截  [basic | advanced | functions] / JSP_NAME
    @RequestMapping("/study")
    public String accessJSP(HttpServletRequest request)
    {
        String jspName = request.getParameter("jspName").trim();
//        System.out.println("access JSP :  "+CONTEXT+jspName+".jsp");

//        int index = request.getRequestURL().toString().indexOf("JSP")+4;
        String subContext = request.getParameter("subContext");

		System.out.println("JSPStudy/study/" + subContext + "/" + jspName);
		return "JSPStudy/study/"+subContext+"/"+jspName;
    }

	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, Model model)
	{
		try
		{
			System.out.println("REQUEST Getting [ " + DateUtils.getCurrentFormatDateTime() + " ] : >>> index <<<");

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return "JSPStudy/index";
	}

}
