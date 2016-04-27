package org.system.domain.accountX;

/**
 * Created by wangyanming on 2016/3/29.
 */
public class AccountXUser
{
    private Integer id;
    private String name;
    private String shortName;

    public String getShortName()
    {
        return shortName;
    }

    public void setShortName(String shortName)
    {
        this.shortName = shortName;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "AccountXUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
