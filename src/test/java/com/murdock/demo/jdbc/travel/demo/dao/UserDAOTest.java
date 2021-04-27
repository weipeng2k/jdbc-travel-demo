package com.murdock.demo.jdbc.travel.demo.dao;

import com.murdock.demo.jdbc.travel.demo.config.MybatisConfig;
import com.murdock.demo.jdbc.travel.demo.dao.dataobject.UserDO;
import com.murdock.demo.jdbc.travel.demo.dao.impl.UserDAOImpl;
import com.murdock.demo.jdbc.travel.demo.dao.param.QueryUserListDAOParam;
import com.murdock.demo.jdbc.travel.demo.gen.IntGen;
import com.murdock.demo.jdbc.travel.demo.gen.StringGen;
import com.murdock.demo.jdbc.travel.demo.gen.impl.IntGenImpl;
import com.murdock.demo.jdbc.travel.demo.gen.impl.StringGenImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author weipeng2k 2021年04月26日 下午15:17:49
 */
@SpringBootTest(classes = UserDAOTest.Config.class)
@TestPropertySource(locations = "classpath:test-application.properties")
@RunWith(SpringRunner.class)
@EnableAutoConfiguration
public class UserDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private IntGen intGen;
    @Autowired
    private StringGen stringGen;

    @Test
    public void insetUser() {
        UserDO userDO = new UserDO();
        userDO.setAge(intGen.gen(18, 35));
        userDO.setEmail(stringGen.gen("email"));
        userDO.setDingTalkNo(stringGen.gen("ding"));
        userDO.setUserName(stringGen.gen("userName"));
        userDO.setLevel(intGen.gen(1, 15));
        userDO.setLevelType(stringGen.gen("M", "P"));
        userDO.setNickName(stringGen.gen("nickName"));
        userDO.setPhoneNum(stringGen.gen("p"));
        userDO.setWorkNum(stringGen.gen("w"));
        userDO.setSex(intGen.gen(0, 2));
        userDO.setType(intGen.gen(1, 10));

        int i = userDAO.insetUser(userDO);
        assertTrue(i > 0);

        UserDO userDO1 = userDAO.queryUser(userDO.getId());
        System.out.println(userDO1);
    }

    @Test
    public void queryUserList() {
        UserDO userDO = new UserDO();
        userDO.setAge(intGen.gen(18, 35));
        userDO.setEmail(stringGen.gen("email"));
        userDO.setDingTalkNo(stringGen.gen("ding"));
        userDO.setUserName(stringGen.gen("userName"));
        userDO.setLevel(intGen.gen(1, 15));
        userDO.setLevelType(stringGen.gen("M", "P"));
        userDO.setNickName(stringGen.gen("nickName"));
        userDO.setPhoneNum(stringGen.gen("p"));
        userDO.setWorkNum(stringGen.gen("w"));
        userDO.setSex(intGen.gen(0, 2));
        userDO.setType(intGen.gen(1, 10));

        for (int i = 0; i < 10; i++) {
            userDAO.insetUser(userDO);
        }

        QueryUserListDAOParam param = new QueryUserListDAOParam();
        param.setLevelType("M");
        List<UserDO> userDOS = userDAO.queryUserList(param, 100, 10);
        assertTrue(userDOS.size() > 0);
    }

    @Test
    public void countUserList() {
        UserDO userDO = new UserDO();
        userDO.setAge(intGen.gen(18, 35));
        userDO.setEmail(stringGen.gen("email"));
        userDO.setDingTalkNo(stringGen.gen("ding"));
        userDO.setUserName(stringGen.gen("userName"));
        userDO.setLevel(intGen.gen(1, 15));
        userDO.setLevelType(stringGen.gen("M", "P"));
        userDO.setNickName(stringGen.gen("nickName"));
        userDO.setPhoneNum(stringGen.gen("p"));
        userDO.setWorkNum(stringGen.gen("w"));
        userDO.setSex(intGen.gen(0, 2));
        userDO.setType(intGen.gen(1, 10));

        for (int i = 0; i < 10; i++) {
            userDAO.insetUser(userDO);
        }

        QueryUserListDAOParam param = new QueryUserListDAOParam();
        param.setLevelType("P");
        int i = userDAO.countUserList(param);
        System.out.println(i);
        assertTrue(i > 0);
    }

    @Test
    public void getMaxUserId() {
        UserDO userDO = new UserDO();
        userDO.setAge(intGen.gen(18, 35));
        userDO.setEmail(stringGen.gen("email"));
        userDO.setDingTalkNo(stringGen.gen("ding"));
        userDO.setUserName(stringGen.gen("userName"));
        userDO.setLevel(intGen.gen(1, 15));
        userDO.setLevelType(stringGen.gen("M", "P"));
        userDO.setNickName(stringGen.gen("nickName"));
        userDO.setPhoneNum(stringGen.gen("p"));
        userDO.setWorkNum(stringGen.gen("w"));
        userDO.setSex(intGen.gen(0, 2));
        userDO.setType(intGen.gen(1, 10));

        for (int i = 0; i < 10; i++) {
            userDAO.insetUser(userDO);
        }

        QueryUserListDAOParam param = new QueryUserListDAOParam();
        param.setLevelType("P");
        long start = System.currentTimeMillis();
        long maxUserId = userDAO.getMaxUserId(param);
        System.err.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(maxUserId);
    }

    @Test
    public void getMinUserId() {
        UserDO userDO = new UserDO();
        userDO.setAge(intGen.gen(18, 35));
        userDO.setEmail(stringGen.gen("email"));
        userDO.setDingTalkNo(stringGen.gen("ding"));
        userDO.setUserName(stringGen.gen("userName"));
        userDO.setLevel(intGen.gen(1, 15));
        userDO.setLevelType(stringGen.gen("M", "P"));
        userDO.setNickName(stringGen.gen("nickName"));
        userDO.setPhoneNum(stringGen.gen("p"));
        userDO.setWorkNum(stringGen.gen("w"));
        userDO.setSex(intGen.gen(0, 2));
        userDO.setType(intGen.gen(1, 10));

        for (int i = 0; i < 10; i++) {
            userDAO.insetUser(userDO);
        }

        QueryUserListDAOParam param = new QueryUserListDAOParam();
        param.setLevelType("P");
        long start = System.currentTimeMillis();
        long minUserId = userDAO.getMinUserId(param);
        System.err.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(minUserId);
    }

    @Test
    public void scanUserList() {
        long start = System.currentTimeMillis();
        List<UserDO> userDOS = userDAO.scanUserList(2L, 100L);
        System.out.println("cost:" + (System.currentTimeMillis() - start));
        System.out.println(userDOS.size());
    }

    @Configuration
    @Import(MybatisConfig.class)
    static class Config {
        @Bean
        UserDAO userDAO(SqlSessionTemplate sqlSessionTemplate) {
            return new UserDAOImpl(sqlSessionTemplate);
        }

        @Bean
        IntGen intGen() {
            return new IntGenImpl();
        }

        @Bean
        StringGen stringGen() {
            return new StringGenImpl();
        }
    }
}