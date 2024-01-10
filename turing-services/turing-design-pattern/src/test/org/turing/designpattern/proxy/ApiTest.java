package org.turing.designpattern.proxy;

import org.springframework.beans.factory.BeanFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.turing.designpattern.examples.proxy.IUserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.turing.designpattern.examples.proxy.demo2.GamePlayer;
import org.turing.designpattern.examples.proxy.demo2.GamePlayerProxy;
import org.turing.designpattern.examples.proxy.demo3.Person;
import org.turing.designpattern.examples.proxy.demo3.PersonProxy;
import org.turing.designpattern.examples.proxy.demo3.Student;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_IUserDao() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("100001");
        logger.info("测试结果：{}", res);
    }

    @Test
    public void testStaticGameProxy() {
        GamePlayer A = new GamePlayer("小A"); //定义玩家小A
        GamePlayerProxy playerProxy = new GamePlayerProxy("小B",A); //定义代打玩家小B
        playerProxy.login("我是小A呀","123");  //登陆账号
        playerProxy.win(); //赢了一局
        playerProxy.upgrade(); //上星耀了
    }

    @Test
    public void testPerson() {
        Person student1 = new Student("张三");
        PersonProxy studentProxy = new PersonProxy(student1);
        studentProxy.wakeup();
        studentProxy.sleep();
    }

}