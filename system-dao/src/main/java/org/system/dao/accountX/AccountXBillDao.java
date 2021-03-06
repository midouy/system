package org.system.dao.accountX;

import org.system.domain.accountX.AccountXBill;

import java.util.List;

/**
 * Created by Midouy on 2016/3/28.
 */
public interface AccountXBillDao
{
    List<AccountXBill> getAllBills();

    List<AccountXBill> getBillsLogByRecordId(Integer id);

    Integer DeleteBillById(Integer id);

    Integer deleteAllBills();

    void insertNewBill(AccountXBill bill);

    AccountXBill getBillByTime(String date);

    Integer updateBillRecordId(Integer recordId);

}
