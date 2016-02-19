package org.system.domain;

/**
 * Created by wangyanming on 2015/9/11.
 */
public class Article
{
    private int id;
    //student 就是用户的作者
    private Student student;
    private String title;
    private String content;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "Article --> { id = " + this.id + " , student = " + student.toString() + " , title = " + this.title + " , content = " + this.content+" }";
    }
}
