package org.system.service;

import org.springframework.stereotype.Service;
import org.system.dao.StudentDao;
import org.system.domain.Student;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangyanming on 2015/9/9.
 */
@Service("studentService")
public class StudentService
{
    @Resource
    private StudentDao studentDao;

    public Student getStudent(String name)
    {
        return studentDao.getStudent(name);
    }

    public void addStudent(Student student)
    {
        studentDao.addStudent(student);
    }

    public void editStudent(Student student)
    {
        studentDao.editStudent(student);
    }

    public void deleteStudent(String name)
    {
        studentDao.deleteStudent(name);
    }

    public List<Student> listStudents()
    {
        return studentDao.listStudents();
    }
}
