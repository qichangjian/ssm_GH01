package com.qcj.test;

import com.qcj.mapper.UserInfosMapper;
import com.qcj.service.UserInfosService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.Reader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/qcj/config/applicationContext.xml")
public class JunitTest {
    /**
     * 测试 mybatis搭建是否完成
     *      如果成功：只用mybatis就搭建成功了
     */
    @Test
    public void testMybatis() throws IOException {
        //加载配置mysql文件
        Reader reader = Resources.getResourceAsReader("com/qcj/config/mybatis.xml");
        SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = ssf.openSession(true);
        UserInfosMapper mapper = session.getMapper(UserInfosMapper.class);
        session.close();
    }



    /**
     *     整合mybatis和spring
     *          修改mybatis 和 spring配置文件,把数据库连接和事务交给spring来创建。
     *     如果成功：  spring整合mybatis就完成了
     */
    @Autowired
    UserInfosService userInfosService;
    @Test
    public void testService() {
        System.out.println( userInfosService.queryAll());
    }

    /**
     *  整合springmvc
     *
     *  创建springmvc.xml扫描controller包，配置前台控制器分发请求的bean. 配置视图解析器
     *  在web.xml中配置前端控制器，并配置servlet的访问控制。如果想要得到service对象，需要在web.xml中配置applicationContext.xml的访问路径
     *
     */
}
