package com.sq.gaox;

import com.sq.gaox.bean.SysTeacher;
import com.sq.gaox.bean.User;
import com.sq.gaox.bettl.mapper.SysTeacherMapper;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlSqlTest {
    private SQLManager sqlManager=null;
    @Before
    public void before(){
        ConnectionSource source= ConnectionSourceHelper.getSimple("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/gx?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root","root");
        DBStyle mysql= new MySqlStyle();
        SQLLoader loader=new ClasspathLoader("/sql");
        UnderlinedNameConversion nc=new UnderlinedNameConversion();
         sqlManager=new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
    }

    @Test
    public void createTable(){

        Map map=new HashMap();
        map.put("param0","sys_student");
        map.put("param1","id");
        map.put("param2","name");
        map.put("param3","age");
        map.put("param4","create_time");
        int a=sqlManager.insert("user.createTable",map,null,null);
        System.out.println(a);
    }
    @Test
    public void select(){
        User query = new User();
        query.setName("gx");
        List<User> list = sqlManager.select("user.select",User.class,query);
        Assert.assertTrue(list.size()>0);
       List<SysTeacher> teachers= sqlManager.query(SysTeacher.class).andEq("name","lisi10").select();
       Assert.assertTrue(teachers.size()>0);
       SysTeacher teacher=sqlManager.unique(SysTeacher.class,4003);
       Assert.assertNotNull(teacher);
       SysTeacher teacher1=sqlManager.single(SysTeacher.class,1);
       Assert.assertNull(teacher1);
       List<SysTeacher> list1=sqlManager.all(SysTeacher.class);
       Assert.assertNotNull(list1);
       List<SysTeacher> list2=sqlManager.all(SysTeacher.class,1,10);
       Assert.assertNotNull(list2);
       Long total=sqlManager.allCount(SysTeacher.class);
       Assert.assertNotNull(total);
      List<SysTeacher> list3 =sqlManager.query(SysTeacher.class).andLike("name","li%").select();
      Assert.assertNotNull(list3);
      SysTeacher sysTeacher=new SysTeacher();
      sysTeacher.setName("lisi11");
      List<SysTeacher> list4=sqlManager.template(sysTeacher);
      Assert.assertNotNull(list4);


    }

    @Test
    public void selectByMapper(){
        SysTeacherMapper mapper=sqlManager.getMapper(SysTeacherMapper.class);
        List<SysTeacher> list=mapper.selectByCon("lisi10");
        Assert.assertNotNull(list);
    }
    @Test
    public void insert() {
        User user=new User();
        user.setName("zm");
        user.setAge(19);
        user.setCreateDate(new Date());
        int a=sqlManager.insert(User.class,user);
        Assert.assertTrue(a>0);
    }
    @Test
    public void insert2(){
        User user=new User();
        user.setName("lisi");
        user.setAge(19);
        user.setCreateDate(new Date());
        int a=sqlManager.insert(user);
        System.out.println(a);
    }
    @Test
    public void insert3(){
        SysTeacher user=new SysTeacher();
        user.setName("lisi");
        user.setAge(19);
        user.setCreateTime(new Date());
        int a=sqlManager.insert(user);
        System.out.println(a);
    }
    @Test
    public void insertBatch(){
        List<SysTeacher> list=new ArrayList<>();
        SysTeacher teacher=null;
        for (int i = 0; i < 1000; i++) {
            teacher=new SysTeacher();
            teacher.setName("lisi"+i);
            teacher.setAge(19);
            teacher.setCreateTime(new Date());
            list.add(teacher);
        }
        long b=System.currentTimeMillis();
        int[] a=sqlManager.insertBatch(SysTeacher.class,list);
        System.out.println(a.length);
        System.out.println(System.currentTimeMillis()-b);
    }
    @Test
    public void insertBatch2(){
        List<SysTeacher> list=new ArrayList<>();
        SysTeacher teacher=null;
        for (int i = 0; i < 10000; i++) {
            teacher=new SysTeacher();
            teacher.setName("lisi"+i);
            teacher.setAge(19);
            teacher.setCreateTime(new Date());
            list.add(teacher);
        }
        long b=System.currentTimeMillis();

        Map map=new HashMap();
        map.put("list",list);
        int a=sqlManager.insert("user.insertBatch",map,null,null);
        System.out.println(a);
        System.out.println(System.currentTimeMillis()-b);
    }


}
