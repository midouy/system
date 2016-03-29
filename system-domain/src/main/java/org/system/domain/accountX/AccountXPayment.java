package org.system.domain.accountX;

/**
 * Created by wangyanming on 2016/3/29.
 */
public class AccountXPayment
{
    private Integer id;
    private Integer billId;
    private String from;
    private String to;
    private float money;

    public AccountXPayment(){

    }

    public AccountXPayment(String from, String to){
        this.id=-1;
        this.billId = -100;
        this.from= from;
        this.to = to;
        this.money = 0;
    }

    public AccountXPayment(Integer billId, String from, String to, float money)
    {
        this.billId = billId;
        this.from = from;
        this.to = to;
        this.money = money;
    }

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
        return "AccountXPayment{" +
                "id=" + id +
                ", billId=" + billId +
                ", from=" + from +
                ", to=" + to +
                ", money=" + money +
                '}';
    }

    public boolean canMerge( AccountXPayment that){
        if(this.getFrom().equals(that.getFrom())&&this.getTo().equals(that.getTo()))
            return true;
        if(this.getFrom().equals(that.getTo())&&this.getTo().equals(that.getFrom()))
            return true;
        return false;
    }

    public void merge(AccountXPayment that){
        try{
            if(canMerge(that)==false||this.getId()>0)
                throw new RuntimeException("Payment merge Exception !!!");
            if(this.from.equals(that.from))
                this.setMoney(this.getMoney()+that.getMoney());
            else
                this.setMoney(this.getMoney()-that.getMoney());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void format(){
        String temp = this.getFrom();
        this.setFrom(this.getTo());
        this.setTo(temp);
        this.setMoney(this.getMoney()*(-1));
    }
}
