package org.system.dao.account;

import org.system.domain.account.BillResult;

import java.util.List;

/**
 * Created by wangyanming on 2016/2/4.
 */
public interface BillResultDao
{
    Integer addBillResult(BillResult billResult);
    List<BillResult> listAllResultHistory();
}
