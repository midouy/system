package org.system.domain.accountX;

/**
 * Created by wangyanming on 2016/3/29.
 */
public class AccountXPayment
{
    private Integer id;
    private Integer billId;
    private AccountXUser from;
    private AccountXUser to;
    private float money;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getBillId()
    {
        return billId;
    }

    public void setBillId(Integer billId)
    {
        this.billId = billId;
    }

    public AccountXUser getFrom()
    {
        return from;
    }

    public void setFrom(AccountXUser from)
    {
        this.from = from;
    }

    public AccountXUser getTo()
    {
        return to;
    }

    public void setTo(AccountXUser to)
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
        return "AccountXPayment{" +
                "id=" + id +
                ", billId=" + billId +
                ", from=" + from +
                ", to=" + to +
                ", money=" + money +
                '}';
    }
}
