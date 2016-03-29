package org.system.service.accountX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.system.dao.accountX.AccountPaymentDao;
import org.system.dao.accountX.AccountXBillDao;
import org.system.dao.accountX.AccountXUserDao;
import org.system.domain.accountX.AccountXBill;
import org.system.domain.accountX.AccountXPayment;
import org.system.domain.accountX.AccountXUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Midouy on 2016/3/28.
 */
@Service
public class AccountXService
{

    @Autowired
    private AccountXBillDao accountXBillDao;
    //
    @Autowired
    private AccountPaymentDao accountPaymentDao;
    //
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
        List<AccountXPayment> allPayments = accountPaymentDao.getAllPayment();
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
            if(resultItem.getMoney()<0){
                resultItem.format();
            }
        }
    }

    public void show(List data){
        for(Object object : data){
            System.out.println(object.toString());
        }
    }
}
