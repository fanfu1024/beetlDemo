package com.sq.gaox;

import com.sq.gaox.bean.User;
import com.sq.gaox.util.DateUtil;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeetlDemoApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void beetlTest(){
        ConnectionSource source= ConnectionSourceHelper.getSimple("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/gx?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root","root");
        DBStyle mysql= new MySqlStyle();
        SQLLoader loader=new ClasspathLoader("/sql");
        UnderlinedNameConversion nc=new UnderlinedNameConversion();
        SQLManager sqlManager=new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        User query = new User();
        query.setName("gx");
        List<User> list2 = sqlManager.select("user.select",User.class,query);
        User a=new User();
        a.setName("gaox");
        a.setAge(19);
        Map map=new HashMap();
        map.put("name","gaox");
        map.put("age",19);
        sqlManager.insert("user.insert",map,null,null);
        System.out.println(list2.size());
    }
    @Test
    public void createTable(){
        ConnectionSource source= ConnectionSourceHelper.getSimple("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/gx?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root","root");
        DBStyle mysql= new MySqlStyle();
        SQLLoader loader=new ClasspathLoader("/sql");
        UnderlinedNameConversion nc=new UnderlinedNameConversion();
        SQLManager sqlManager=new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        Map map=new HashMap();
        map.put("param0","dy"+ DateUtil.dateFormat(new Date(),DateUtil.DATE_TIME_PATTERN2));
        map.put("param1","id");
        map.put("param2","name");
        map.put("param3","age");
        map.put("param4","create_time");
        int a=sqlManager.insert("user.createTable",map,null,null);
        System.out.println(a);
    }
    @Test
    public void insertBatch(){
        ConnectionSource source= ConnectionSourceHelper.getSimple("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/gx?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC","root","root");
        DBStyle mysql= new MySqlStyle();
        SQLLoader loader=new ClasspathLoader("/sql");
        UnderlinedNameConversion nc=new UnderlinedNameConversion();
        SQLManager sqlManager=new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        Map map=new HashMap();
        map.put("param0","dy20190409164911");
        map.put("param1","name");
        map.put("param2","age");
        map.put("name","zm");
        map.put("age",29);
        int a=0;
        long s=System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
           a=a+sqlManager.insert("user.insertBatch",map,null,null);
        }
        System.out.println(System.currentTimeMillis()-s);
        System.out.println(a);
    }
}
