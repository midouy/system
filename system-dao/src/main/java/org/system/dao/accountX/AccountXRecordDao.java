package org.system.dao.accountX;

import org.system.domain.accountX.AccountXRecord;

import java.util.List;

/**
 * Created by wangyanming on 2016/3/30.
 */
public interface AccountXRecordDao
{
    List<AccountXRecord> getAllRecord();

    AccountXRecord getRecentRecord();

    AccountXRecord getRecordByTime(String time);

    AccountXRecord getRecordById(Integer id);

    Integer insertNewRecord(AccountXRecord record);


}
