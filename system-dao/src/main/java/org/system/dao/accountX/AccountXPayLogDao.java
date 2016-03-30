package org.system.dao.accountX;

import org.system.domain.accountX.AccountXPayLog;

import java.util.List;

/**
 * Created by wangyanming on 2016/3/30.
 */
public interface AccountXPayLogDao
{
    List<AccountXPayLog> getPayLogByRecordId(Integer id);

    Integer insertNewPayLog(AccountXPayLog payLog);
}
