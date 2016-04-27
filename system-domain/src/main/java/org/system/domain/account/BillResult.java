package org.system.domain.account;

/**
 * Created by wangyanming on 2016/2/4.
 */
public class BillResult
{
    private Integer id;
    private float w_Give_l ;
    private float w_Give_c ;
    private float w_Give_z ;
    private float l_Give_c;
    private float l_Give_z;
    private float c_Give_z;
    private String date;

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public float getW_Give_l()
    {
        return w_Give_l;
    }

    public void setW_Give_l(float w_Give_l)
    {
        this.w_Give_l = w_Give_l;
    }

    public float getW_Give_c()
    {
        return w_Give_c;
    }

    public void setW_Give_c(float w_Give_c)
    {
        this.w_Give_c = w_Give_c;
    }

    public float getW_Give_z()
    {
        return w_Give_z;
    }

    public void setW_Give_z(float w_Give_z)
    {
        this.w_Give_z = w_Give_z;
    }

    public float getL_Give_c()
    {
        return l_Give_c;
    }

    public void setL_Give_c(float l_Give_c)
    {
        this.l_Give_c = l_Give_c;
    }

    public float getL_Give_z()
    {
        return l_Give_z;
    }

    public void setL_Give_z(float l_Give_z)
    {
        this.l_Give_z = l_Give_z;
    }

    public float getC_Give_z()
    {
        return c_Give_z;
    }

    public void setC_Give_z(float c_Give_z)
    {
        this.c_Give_z = c_Give_z;
    }

    public String decode_WL(){
        if(this.getW_Give_l()>=0)
            return "王雁鸣   给   刘偌含   "+this.getW_Give_l()+" 元";
        else
            return "刘偌含   给   王雁鸣   "+(this.getW_Give_l()*(-1))+" 元";
    }
    public String decode_WC(){
        if(this.getW_Give_c()>=0)
            return "王雁鸣   给   陈   茜   "+this.getW_Give_c()+" 元";
        else
            return "陈   茜   给   王雁鸣   "+(this.getW_Give_c()*(-1))+" 元";
    }
    public String decode_WZ(){
        if(this.getW_Give_z()>=0)
            return "王雁鸣   给   张晓巍   "+this.getW_Give_z()+" 元";
        else
            return "张晓巍   给   王雁鸣   "+(this.getW_Give_z()*(-1))+" 元";
    }
    public String decode_LC(){
        if(this.getL_Give_c()>=0)
            return "刘偌含   给   陈   茜   "+this.getL_Give_c()+" 元";
        else
            return "陈   茜   给   刘偌含   "+(this.getL_Give_c()*(-1))+" 元";
    }
    public String decode_LZ(){
        if(this.getL_Give_z()>=0)
            return "刘偌含   给   张晓巍   "+this.getL_Give_z()+" 元";
        else
            return "张晓巍   给   刘偌含   "+(this.getL_Give_z()*(-1))+" 元";
    }
    public String decode_CZ(){
        if(this.getC_Give_z()>=0)
            return "陈   茜   给  张晓巍   "+this.getC_Give_z()+" 元";
        else
            return "张晓巍   给   陈   茜   "+(this.getC_Give_z()*(-1))+" 元";
    }
}
