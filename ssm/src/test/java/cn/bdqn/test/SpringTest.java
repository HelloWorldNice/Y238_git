package cn.bdqn.test;

import cn.bdqn.service.AccountService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void testSpring() throws Exception{

        ApplicationContext ac =  new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        accountService.queryAll();
    }
}
