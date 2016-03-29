package org.system.service.accountX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.system.dao.accountX.AccountXPaymentDao;
import org.system.dao.accountX.AccountXBillDao;
import org.system.dao.accountX.AccountXUserDao;
import org.system.domain.accountX.AccountXBill;
import org.system.domain.accountX.AccountXPayment;
import org.system.domain.accountX.AccountXUser;

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

    public void initPage(Model model)
    {
        List<AccountXUser> allUsers = accountXUserDao.getAllUser();
        List<AccountXBill> allBills = accountXBillDao.getAllBills();
        List<AccountXPayment> allPayments = initPaymentResult();

        show(allUsers);
        show(allBills);
        show(allPayments);

        model.addAttribute("allUsers", allUsers);
        model.addAttribute("allBills", allBills);
        model.addAttribute("allPayments", allPayments);
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

    public void show(List data)
    {
        System.out.println("show ... ");
        for (Object object : data)
        {
            System.out.println(object.toString());
        }
    }

    public void show(Set data)
    {
        for (Object object : data)
        {
            System.out.println(object.toString());
        }
    }

    public void show(Object[] data)
    {
        System.out.println("show ... ");
        for (Object object : data)
        {
            System.out.println(object.toString());
        }
    }

//    @Transactional(rollbackFor = Exception.class)
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
        return successResult(" Bill insert success ! ");
    }

    public Map<String, Object> successResult(String msg)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("message", msg);
        return result;
    }

    public Map<String, Object> failResult(String msg)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        result.put("message", msg);
        return result;
    }
}
