package org.system.web.controller.main;

import bit.wym.commons.date.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Midouy on 2016/4/23.
 */
@Controller
@RequestMapping("/main")
public class mainIndexController
{
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
		return "index";
	}
}
