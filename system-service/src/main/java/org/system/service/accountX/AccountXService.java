package org.system.service.accountX;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.system.dao.accountX.AccountXBillDao;
import org.system.dao.accountX.AccountXUserDao;
import org.system.domain.accountX.AccountXBill;
import org.system.domain.accountX.AccountXUser;

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
//    @Autowired
//    private AccountResultDao accountResultDao;
//
    @Autowired
    private AccountXUserDao accountXUserDao;

    public void initPage(Model model)
    {
        List<AccountXUser> allUsers = accountXUserDao.getAllUser();
        List<AccountXBill> allBills = accountXBillDao.getAllBills();

        model.addAttribute("allUsers", allUsers);
        model.addAttribute("allBills", allBills);

    }
}
