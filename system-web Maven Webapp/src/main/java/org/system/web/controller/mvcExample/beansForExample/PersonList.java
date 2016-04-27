package org.system.web.controller.mvcExample.beansForExample;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangyanming on 2016/4/21.
 */
public class PersonList
{
	private List<Person> persons;

	private String title;

	private int age;

	@Override
	public String toString()
	{
		return "PersonList{" +
				"persons=" + Arrays.deepToString(persons.toArray()) +
				", title='" + title + '\'' +
				", age=" + age +
				'}';
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public List<Person> getPersons()
	{
		return persons;
	}

	public void setPersons(List<Person> persons)
	{
		this.persons = persons;
	}
}
