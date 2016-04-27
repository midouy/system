package org.system.dao.accountX;


import org.system.domain.accountX.AccountXPayment;

import java.util.List;

/**
 * Created by Midouy on 2016/3/28.
 */
public interface AccountXPaymentDao
{
    List<AccountXPayment> getAllPayment();

    Integer insertNewPayment(AccountXPayment accountXPayment);

    Integer deletePaymentByBillId(Integer id);

    Integer deleteAllPayment();
}
