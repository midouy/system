package org.system.dao;

import org.system.domain.account.Bill;

import java.util.List;

/**
 * Created by wangyanming on 2016/2/4.
 */
public interface BillDao
{
    Bill getBill(Integer id);
    Integer addBill(Bill bill);
    Integer deleteBill(Integer id);
    Integer deleteAll();
    List<Bill> listAllBill();
}
