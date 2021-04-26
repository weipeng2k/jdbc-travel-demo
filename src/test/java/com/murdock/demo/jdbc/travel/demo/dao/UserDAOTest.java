package com.murdock.demo.jdbc.travel.demo.dao;

import com.murdock.demo.jdbc.travel.demo.config.MybatisConfig;
import com.murdock.demo.jdbc.travel.demo.dao.dataobject.UserDO;
import com.murdock.demo.jdbc.travel.demo.dao.impl.UserDAOImpl;
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
    }

    @Test
    public void countUserList() {
    }

    @Test
    public void getMaxUserId() {
    }

    @Test
    public void getMinUserId() {
    }

    @Test
    public void scanUserList() {
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