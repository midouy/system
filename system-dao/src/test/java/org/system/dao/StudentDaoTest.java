package org.system.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.system.domain.Article;
import org.system.domain.Student;

import java.io.Reader;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by wangyanming on 2015/9/9.
 */
public class StudentDaoTest
{
    private static Log logger = LogFactory.getLog(StudentDaoTest.class);
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static
    {
        try
        {
//         读取配置文件
            reader = Resources.getResourceAsReader("mybatis.config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
            //这里的development指的是mybatis.config.xml中的默认environment
            //如果存在多个<environment>, 这个参数用于指定特定的数据库
            //使用的时候, 每个SQLSessionFactory对应一个数据库
            //如果这个参数不写, 则使用xml文件中的默认<environment>
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession()
    {
        return sqlSessionFactory;
    }

    public static void main(String [] args)
    {
//        TestSelect();
//        TestInsert();
//        TestList();
//        TestDelete();
//        TestUpdate();

//        TestList();
//        TestAnnotation();
        TestSelectArticle();
    }

    //测试单个对象查找
    public static void TestSelect()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //方式一 : mybatis 的 session 方法调用
            Student student = (Student)session.selectOne("StudentDao.getStudent","cc");
            System.out.println(student);

            //方式二 : 获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);
            student = studentDao.getStudent("mm");
            System.out.println(student);

            session.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    //测试列表查找
    public static void TestList()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);
            List<Student> students = studentDao.listStudents();

            for(Student student :students)
            {
                System.out.println(student);
            }
            session.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    //测试插入对象
    public static void TestInsert()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);
            Student student = new Student("xx",30, (byte)0);

            studentDao.addStudent(student);
            session.commit();
        }
        catch (Exception e)
        {
            logger.error("Student add exception : ", e);
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    //测试删除数据
    public static void TestDelete()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);

            studentDao.deleteStudent("mm");

            session.commit();
        }
        catch (Exception e)
        {
            logger.error("Student add exception : ", e);
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    //测试更新数据
    public static void TestUpdate()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);

            Student student = new Student("cc",100,(byte)0);

            studentDao.editStudent(student);

            session.commit();
        }
        catch (Exception e)
        {
            logger.error("Student add exception : ", e);
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    //测试查询某个学生的所有文章
    public static void TestSelectArticle()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);

            List<Article> articles = studentDao.getStudentArticles("cc");

            for(Article article : articles)
            {
                System.out.println(article);
            }

            session.commit();
        }
        catch (Exception e)
        {
            logger.error("Student add exception : ", e);
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    //测试注解式DaoMapper方法的调用
    public static void TestAnnotation()
    {
        SqlSession session = sqlSessionFactory.openSession();
        try
        {
            //方式二 : 获取StduentDao对象(推荐)
            StudentDao studentDao = session.getMapper(StudentDao.class);
            //getStudentByAge是采用注解形式进行Mapper实现的
            Student student = studentDao.getStudentByAge(100);
            System.out.println(student);

            session.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    @Test
    public void testJunit()
    {
        Assert.assertThat(3+5, is(8));
    }

}
