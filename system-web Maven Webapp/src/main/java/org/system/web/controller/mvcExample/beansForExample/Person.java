package org.system.web.controller.mvcExample.beansForExample;

/**
 * Created by wangyanming on 2016/4/19.
 */
public class Person
{
	private String name ;
	private String address ;

	public Person() {

	}

	@Override
	public String toString()
	{
		return "Person{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
}
