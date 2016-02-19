package org.system.domain.account;

/**
 * Created by wangyanming on 2016/2/3.
 */
public class Bill
{
    private Integer id;
    private String payPerson;
    private boolean shareWYM;
    private boolean shareLRH;
    private boolean shareCX;
    private boolean shareZXW;
    private float money;
    private String note;
    private String date;


    public Bill()
    {
    }
    public Bill(String payPerson, boolean shareWYM, boolean shareLRH, boolean shareCX, boolean shareZXW, float money, String note)
    {
        this.note = note;
        this.money = money;
        this.shareZXW = shareZXW;
        this.shareCX = shareCX;
        this.shareLRH = shareLRH;
        this.shareWYM = shareWYM;
        this.payPerson = payPerson;
    }

    public int countShare(){
        int count =0 ;
        if(this.isShareWYM())
            count++;
        if(this.isShareLRH())
            count++;
        if(this.isShareCX())
            count++;
        if(this.isShareZXW())
            count++;
        return count;
    }

    public float shareMoney(){
        return this.getMoney()/((float)this.countShare());
    }


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public boolean isShareWYM()
    {
        return shareWYM;
    }

    public void setShareWYM(boolean shareWYM)
    {
        this.shareWYM = shareWYM;
    }

    public boolean isShareLRH()
    {
        return shareLRH;
    }

    public void setShareLRH(boolean shareLRH)
    {
        this.shareLRH = shareLRH;
    }

    public boolean isShareCX()
    {
        return shareCX;
    }

    public void setShareCX(boolean shareCX)
    {
        this.shareCX = shareCX;
    }

    public boolean isShareZXW()
    {
        return shareZXW;
    }

    public void setShareZXW(boolean shareZXW)
    {
        this.shareZXW = shareZXW;
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

    public String getPayPerson()
    {
        return payPerson;
    }

    public void setPayPerson(String payPerson)
    {
        this.payPerson = payPerson;
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
        return "Bill{" +
                "id=" + id +
                ", payPerson='" + payPerson + '\'' +
                ", shareWYM=" + shareWYM +
                ", shareLRH=" + shareLRH +
                ", shareCX=" + shareCX +
                ", shareZXW=" + shareZXW +
                ", money=" + money +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
