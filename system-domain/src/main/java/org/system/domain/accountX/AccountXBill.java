package org.system.domain.accountX;

/**
 * Created by wangyanming on 2016/3/29.
 */
public class AccountXBill
{
    private Integer id;
    private String payer;
    private float money;
    private String date ;
    private String note;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPayer()
    {
        return payer;
    }

    public void setPayer(String payer)
    {
        this.payer = payer;
    }

    public float getMoney()
    {
        return money;
    }

    public void setMoney(float money)
    {
        this.money = money;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    @Override
    public String toString()
    {
        return "AccountXBill{" +
                "id=" + id +
                ", payer=" + payer +
                ", money=" + money +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
