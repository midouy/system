package org.system.web.controller.accountX;

import bit.wym.commons.math.Calculater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.system.common.response.ResponseUtil;
import org.system.common.utils.IpUtils;
import org.system.domain.accountX.AccountXBill;
import org.system.service.accountX.AccountXService;
import org.system.web.annotation.SystemControllerLog;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Midouy on 2016/3/28.
 */
@Controller
@RequestMapping("/accountX")
public class AccountXController
{

    @Autowired
    private AccountXService accountXService;

    @RequestMapping("/index")
	@SystemControllerLog(description = "index")
    public String index(HttpServletRequest request, Model model)
    {
        try
        {
            System.out.println("\r\nAccessing : "+IpUtils.getRealIp(request)+"\r\n");
            accountXService.initPage(model);
        } catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "页面初始化错误");
            return "accountX/Error";
        }
        return "accountX/index";
    }

    @RequestMapping("/log")
    public String toLog(Model model, Integer recordId)
    {
        try
        {
            accountXService.initLogPage(model, recordId);
        } catch (Exception e)
        {
            e.printStackTrace();
            model.addAttribute("msg", "日志页面初始化错误");
            return "accountX/Error";
        }
        return "accountX/log";
    }

    @RequestMapping(value = "/addBill", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addBill(String sharesData, String payer, String money)
    {
        float m = 0;
        try
        {
            if (money == null || money.equals(""))
            {
                return ResponseUtil.failResult("金额格式不正确 !");
            }
            m = Float.parseFloat(Calculater.doCalculate(money));
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(date);
            String[] sharesArray = sharesData.split("@");

            System.out.println(m);
            AccountXBill accountXBill = new AccountXBill(payer, m, time, "( " + sharesData.replaceAll("@", "  ") + " )");
            return accountXService.insertNewBill(accountXBill, sharesArray);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return ResponseUtil.failResult(" 金额格式不正确 !");
    }

    @RequestMapping(value = "/doRecord", method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> doRecord(String note){
        return accountXService.doRecord(note);
    }

    @RequestMapping("/deleteBill")
    @ResponseBody
    public Map<String, Object> deleteBill(Integer id)
    {
        return accountXService.deleteBillById(id);
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String, Object> deleteAll()
    {
        return accountXService.deleteAll();
    }

}
