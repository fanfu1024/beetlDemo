package com.sq.gaox;

import com.sq.gaox.bean.SysStudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author gaox
 * @description
 * @date 2019/4/10 09:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {


    @Test
    public void test(){
        InputStream inputStream= null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<SysStudent> list=new ArrayList<>();
        SysStudent student=null;
        for (int i = 0; i <10000 ; i++) {
            student=new SysStudent();
            student.setName("stu"+i);
            student.setAge(20);
            student.setCreateTime(new Date());
            list.add(student);
        }
        long a=System.currentTimeMillis();
        int b=sqlSession.insert("com.sq.gaox.mapper.SysStudentMapper.insertBatch",list);
        sqlSession.commit();
        System.out.println(b);
        System.out.println(System.currentTimeMillis()-a);
        sqlSession.commit();
    }
}
