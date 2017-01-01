package org.system.web.controller.contacts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.system.common.utils.IpUtils;
import org.system.service.contacts.ContactsService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by midouy on 2016/12/29.
 */

@Controller
@RequestMapping("/contacts")
public class ContactsController
{
	@Autowired
	ContactsService service;

	private static Log logger = LogFactory.getLog(ContactsController.class);
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model){
		try
		{
			System.out.println("\r\nAccessing : "+ IpUtils.getRealIp(request)+"\r\n");
			logger.info("Application [Contacts] Accessing ... ");
			service.initPage(model);
		} catch (Exception e)
		{
			e.printStackTrace();
			model.addAttribute("msg", "页面初始化错误");
			return "contacts/Error";
		}
		return "contacts/index";
	}
}
