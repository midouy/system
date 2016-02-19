package org.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.util.mail.MailTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyanming on 2015/12/28.
 */
@Controller
@RequestMapping("mail")
public class MailController
{
    @RequestMapping("/test")
    @ResponseBody
    public Map<String , Object> mailtest(){
        new MailTest().test();
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success",true);
        return result;
    }

}
