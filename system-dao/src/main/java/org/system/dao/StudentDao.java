package org.system.dao;

import org.apache.ibatis.annotations.Select;
import org.system.domain.Article;
import org.system.domain.Student;

import java.util.HashSet;
import java.util.List;

/**
 * Created by wangyanming on 2015/9/9.
 */
public interface StudentDao
{
    Student getStudent(String name);

    @Select("select * from students where age = #{age}")
    Student getStudentByAge(Integer age);

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(String name);

    List<Student> listStudents();

    List<Article> getStudentArticles(String name);
}
