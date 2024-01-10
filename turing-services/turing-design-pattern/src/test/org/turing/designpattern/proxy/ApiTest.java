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
import org.turing.designpattern.examples.proxy.dynamics.demo1.JdkProxy;

import java.lang.reflect.Proxy;

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

    /**
     * @descri: 可以看到，相对于静态代理类来说，无论有多少接口，这里只需要一个代理类。核心代码也很简单。唯一需要注意的点有以下2点：
     * JDK动态代理是需要声明接口的，创建一个动态代理类必须得给这个”虚拟“的类一个接口。
     * 可以看到，这时候经动态代理类创造之后的每个bean已经不是原来那个对象了。
     * 这里JdkProxy最核心的方法就是:
     * public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
     * 其中proxy为代理过之后的对象(并不是原对象)，method为被代理的方法，args为方法的参数。
     * 如果你不传原有的bean，直接用method.invoke(proxy, args)的话，那么就会陷入一个死循环。
     *  */
    @Test
    public void testDynamicPerson() {
        JdkProxy proxy = new JdkProxy(new Student("李四"));
        Person student = (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class}, proxy);
        student.wakeup();
        student.sleep();
    }

}