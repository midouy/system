package org.system.web.controller.main;

import bit.wym.commons.date.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.common.response.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
