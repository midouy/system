package org.system.service.accountX;

import bit.wym.commons.util.DataShower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.system.common.response.ResponseUtil;
import org.system.dao.accountX.*;
import org.system.domain.accountX.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Midouy on 2016/3/28.
 */
@Service
public class AccountXService
{
    @Autowired
    private AccountXBillDao accountXBillDao;

    @Autowired
    private AccountXPaymentDao accountXPaymentDao;

    @Autowired
    private AccountXUserDao accountXUserDao;

    @Autowired
    private AccountXRecordDao accountXRecordDao;

    @Autowired
    private AccountXPayLogDao accountXPayLogDao;

    public void initPage(Model model)
    {
        List<AccountXUser> allUsers = accountXUserDao.getAllUser();
        List<AccountXBill> allBills = accountXBillDao.getAllBills();
        List<AccountXPayment> allPayments = initPaymentResult();
        float moneySum = moneySum(allBills);

        DataShower.show(allUsers);
//        DataShower.show(allBills);
//        DataShower.show(allPayments);

        model.addAttribute("allUsers", allUsers);
        model.addAttribute("allBills", allBills);
        model.addAttribute("allPayments", allPayments);
        model.addAttribute("moneySum", moneySum);
    }

    public void initLogPage(Model model, Integer recordId)
    {
        if(recordId==null||recordId<=0){
            AccountXRecord recentRecord = accountXRecordDao.getRecentRecord();
            recordId = recentRecord.getId();
        }

        List<AccountXRecord> allRecords = accountXRecordDao.getAllRecord();
        List<AccountXPayLog> allPayLogs = accountXPayLogDao.getPayLogByRecordId(recordId);
        List<AccountXBill> allBillLogs = accountXBillDao.getBillsLogByRecordId(recordId);
        AccountXRecord record = accountXRecordDao.getRecordById(recordId);

        DataShower.show(allRecords);
//        DataShower.show(allPayLogs);
//        DataShower.show(allBillLogs);
//        DataShower.show(record);

        model.addAttribute("allRecords",allRecords);
        model.addAttribute("allPayLogs",allPayLogs);
        model.addAttribute("allBillLogs",allBillLogs);
        model.addAttribute("record",record);
    }

    private List<AccountXPayment> initPaymentResult()
    {
        List<AccountXPayment> allPayments = accountXPaymentDao.getAllPayment();
        List<AccountXPayment> results = initNullResult();
        mergePayment(results, allPayments);
        return results;
    }

    private List<AccountXPayment> initNullResult()
    {
        List<AccountXPayment> results = new ArrayList<AccountXPayment>();
        List<AccountXUser> allUsers = accountXUserDao.getAllUser();
        AccountXUser[] allUsersArray = allUsers.toArray(new AccountXUser[allUsers.size()]);
        for (int i = 0; i < allUsersArray.length; i++)
        {
            for (int j = i + 1; j < allUsersArray.length; j++)
            {
                results.add(new AccountXPayment(allUsersArray[i].getName(), allUsersArray[j].getName()));
            }
        }
        return results;
    }

    private void mergePayment(List<AccountXPayment> results, List<AccountXPayment> allPayments)
    {
        for (AccountXPayment resultItem : results)
        {
            for (AccountXPayment payment : allPayments)
            {
                if (resultItem.canMerge(payment))
                {
                    resultItem.merge(payment);
//                    allPayments.remove(payment);
                }
            }
            if (resultItem.getMoney() < 0)
            {
                resultItem.format();
            }
        }
    }

    private float moneySum(List<AccountXBill> allBills)
    {
        float result = 0;
        if(allBills == null)
            return result;
        for(AccountXBill bill : allBills){
            result+=bill.getMoney();
        }
        return result;
    }

    @Transactional
    public Map<String, Object> insertNewBill(AccountXBill accountXBill, String[] shares)
    {
        accountXBillDao.insertNewBill(accountXBill);
        accountXBill = accountXBillDao.getBillByTime(accountXBill.getDate());
        System.out.println(accountXBill);

        float money = accountXBill.getMoney() / shares.length;
        for (String username : shares)
        {
            if (username.equals(accountXBill.getPayer()))
                continue;
            AccountXPayment accountXPayment = new AccountXPayment(accountXBill.getId(), username, accountXBill.getPayer(), money);
            System.out.println(accountXPayment);
            accountXPaymentDao.insertNewPayment(accountXPayment);
        }
        return ResponseUtil.successResult(" Bill insert success ! ");
    }

    @Transactional
    public Map<String, Object> deleteBillById(Integer id)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("bill_delete_Result", accountXBillDao.DeleteBillById(id));
        result.put("payment_delete_Result", accountXPaymentDao.deletePaymentByBillId(id));
        return ResponseUtil.successResult(result, "删除成功");
    }

    @Transactional
    public Map<String, Object> deleteAll()
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("bill_delete_Result", accountXBillDao.deleteAllBills());
        result.put("payment_delete_Result", accountXPaymentDao.deleteAllPayment());
        return ResponseUtil.successResult(result, "全部删除成功");
    }

    @Transactional
    public Map<String , Object> doRecord(String note){
        //计算总计金额
        List<AccountXBill> allBills = accountXBillDao.getAllBills();
        List<AccountXPayment> allPayments = initPaymentResult();
        float moneySum = moneySum(allBills);
        //生成record
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(date);
        AccountXRecord record = new AccountXRecord(moneySum, time, note);

        //通过时间获取recordID
        Integer recordInsert = accountXRecordDao.insertNewRecord(record);
        record = accountXRecordDao.getRecordByTime(time);

        //获取payment结果
        Integer payLogInsert = 0;
        for(AccountXPayment pay : allPayments){
            AccountXPayLog payLog = new AccountXPayLog(record.getId(),pay.getFrom(),pay.getTo(),pay.getMoney());
            payLogInsert+= accountXPayLogDao.insertNewPayLog(payLog);
        }
        //更新bill 的 recordID
        Integer billUpdate = accountXBillDao.updateBillRecordId(record.getId());

        //清空payment表
        Integer paymentsDelete = accountXPaymentDao.deleteAllPayment();

        HashMap<String , Object> result = new HashMap<String, Object>();
        result.put("recordInsert",recordInsert);
        result.put("payLogInsert",payLogInsert);
        result.put("billUpdate",billUpdate);
        result.put("paymentsDelete",paymentsDelete);

        return ResponseUtil.successResult(result,"记录成功!");
    }
}
