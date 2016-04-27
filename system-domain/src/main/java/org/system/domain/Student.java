package org.system.domain;

/**
 * Created by wangyanming on 2015/9/9.
 */
public class Student
{
    private String name;
    private int age;
    private byte sex;

    public Student()
    {
        System.out.println("Student construct !");
    }

    public Student(String name, int age, byte sex)
    {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public byte getSex()
    {
        return sex;
    }

    public void setSex(byte sex)
    {
        this.sex = sex;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return "Student -- > { name = " + this.name + ", age = " + this.age + ", sex = " + (sex == 1 ? "male" : "female")+" }";
    }

    @Override
    public boolean equals(Object student)
    {
        if(student instanceof Student)
        {
            return this.name.equals(((Student) student).getName());
        }
        return false;
    }
}
