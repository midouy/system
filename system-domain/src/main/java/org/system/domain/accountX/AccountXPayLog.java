package org.system.domain.accountX;

/**
 * Created by wangyanming on 2016/3/30.
 */
public class AccountXPayLog
{
    private Integer id;
    private Integer recordId;
    private String from;
    private String to;
    private float money;

    public AccountXPayLog(Integer recordId, String from, String to, float money)
    {
        this.recordId = recordId;
        this.from = from;
        this.to = to;
        this.money = money;
    }

    public AccountXPayLog()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getRecordId()
    {
        return recordId;
    }

    public void setRecordId(Integer recordId)
    {
        this.recordId = recordId;
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public float getMoney()
    {
        return money;
    }

    public void setMoney(float money)
    {
        this.money = money;
    }

    @Override
    public String toString()
    {
        return "AccountXPayLog{" +
                "id=" + id +
                ", recordId=" + recordId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", money=" + money +
                '}';
    }
}
