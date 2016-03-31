package org.system.web.controller.account;

import bit.wym.commons.math.Calculater;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.system.domain.account.Bill;
import org.system.domain.account.BillResult;
import org.system.service.account.AccountService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangyanming on 2016/2/3.
 */
@Controller
@RequestMapping("/account")
public class AccountController
{
    @Resource
    private AccountService accountService;
    private Logger logger = Logger.getLogger(getClass());

    @RequestMapping("/index")
    public String index(Model model)throws Exception{
        List<Bill> list = list();
        List<String> result = calculate();
        logger.info("Account controller Enter !");
        model.addAttribute("list",list);
        model.addAttribute("result",result);
        return "account/index";
    }

    @RequestMapping(value = "/addBill", method = RequestMethod.POST)
    @ResponseBody
    public Map<String , Object> addBill(String payPerson, boolean shareWYM,boolean shareLRH,
    boolean shareCX, boolean shareZXW,String money, String note ){
        float m = 0;
        try {
//            money = Calculater.doCalculate(money);
            m = Float.parseFloat(Calculater.doCalculate(money));
//            m = Float.parseFloat(money);
            System.out.println(money);
            System.out.println(m);
        }catch (Exception e){
            return accountService.failResult("请输入正确的金额");
        }
        Bill bill = new Bill(payPerson,shareWYM,shareLRH,shareCX,shareZXW,m,note);
        if(accountService.checkBill(bill).get("success").equals(false))
            return accountService.checkBill(bill);
        return accountService.addBill(bill);
    }

    @RequestMapping("/deleteBill")
    @ResponseBody
    public Map<String , Object> deleteBill(Integer id){
        return accountService.deleteBill(id);
    }

    @RequestMapping("/deleteAll")
    @ResponseBody
    public Map<String , Object> deleteAll(){
        return accountService.deleteAll();
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Bill> list(){
        return accountService.list();
    }

    @RequestMapping("/calculate")
    @ResponseBody
    public List<String> calculate(){
        BillResult billResult = accountService.calculate();
        List<String> result = new ArrayList<String>();
        result.add( billResult.decode_WL());
        result.add( billResult.decode_WC());
        result.add( billResult.decode_WZ());
        result.add( billResult.decode_LC());
        result.add( billResult.decode_LZ());
        result.add( billResult.decode_CZ());
        return result;
    }

}
