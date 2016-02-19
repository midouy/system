package org.system.service.account;

import org.springframework.stereotype.Service;
import org.system.dao.BillDao;
import org.system.domain.account.Bill;
import org.system.domain.account.BillResult;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wangyanming on 2016/2/3.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service("AccountService")
public class AccountService
{
    @Resource
    private BillDao billDao;

    public Map<String , Object> addBill(Bill bill){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=format.format(date);
        bill.setDate(time);
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println("adding : " + bill.toString());
        result.put("result", billDao.addBill(bill));
        result.put("success",true);
        return result;
    }

    public Map<String, Object>deleteBill(Integer id){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result",billDao.deleteBill(id));
        return result;
    }

    public Map<String, Object>deleteAll(){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("result",billDao.deleteAll());
        return result;
    }

    public List<Bill> list(){
        return billDao.listAllBill();
    }

    public BillResult calculate(){
        List<Bill> allBill = list();
        BillResult result = new BillResult();
        float [][] moneys = new float [4][4];

        //money[0][1] 代表0号需要给1号钱
        for(Bill bill : allBill){
            System.out.println(bill.shareMoney());
            if(bill.isShareWYM())
                moneys[resultOrder("wym")][resultOrder(bill.getPayPerson())]+=bill.shareMoney();
            if(bill.isShareLRH())
                moneys[resultOrder("lrh")][resultOrder(bill.getPayPerson())]+=bill.shareMoney();
            if(bill.isShareCX())
                moneys[resultOrder("cx")][resultOrder(bill.getPayPerson())]+=bill.shareMoney();
            if(bill.isShareZXW())
                moneys[resultOrder("zxw")][resultOrder(bill.getPayPerson())]+=bill.shareMoney();
        }
        result.setW_Give_l(moneys[0][1]-moneys[1][0]);
        result.setW_Give_c(moneys[0][2]-moneys[2][0]);
        result.setW_Give_z(moneys[0][3]-moneys[3][0]);
        result.setL_Give_c(moneys[1][2]-moneys[2][1]);
        result.setL_Give_z(moneys[1][3]-moneys[3][1]);
        result.setC_Give_z(moneys[2][3]-moneys[3][2]);

        return result;
    }

    public int resultOrder(String name){
        if (name.equals("wym")||name.equals("王雁鸣"))
            return 0;
        if (name.equals("lrh")||name.equals("刘偌含"))
            return 1;
        if (name.equals("cx")||name.equals("陈茜"))
            return 2;
        if (name.equals("zxw")||name.equals("张晓巍"))
            return 3;
        else
            return -1;
    }

    public Map<String ,Object> successResult(String msg){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("message",msg);
        return result;
    }

    public Map<String ,Object> failResult(String msg){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success",false);
        result.put("message",msg);
        return result;
    }

    public Map<String ,Object> checkBill(Bill bill){
        if(bill.getPayPerson().equals("default"))
            return failResult("pay 未选择");
        if((bill.isShareWYM()||
                bill.isShareLRH()||
                bill.isShareCX()||
                bill.isShareZXW())==false)
            return failResult("share 未选择");
        return successResult("Bill 检查成功!");
    }
}
