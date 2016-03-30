package org.system.domain.accountX;

/**
 * Created by wangyanming on 2016/3/30.
 */
public class AccountXRecord
{
    private Integer id;
    private float money;
    private String date;
    private String note;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
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
        return "AccountXRecord{" +
                "id=" + id +
                ", money=" + money +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
