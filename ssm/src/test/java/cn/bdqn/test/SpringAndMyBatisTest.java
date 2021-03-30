package cn.bdqn.test;

import cn.bdqn.domain.Account;
import cn.bdqn.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringAndMyBatisTest {

    @Test
    public void testQueryAll() throws Exception{

        ApplicationContext ac =  new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        List<Account> accounts = accountService.queryAll();
        System.out.println(accounts);
    }

    @Test
    public void testSave() throws Exception{

        ApplicationContext ac =  new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");

        Account account = new Account();
        account.setName("黄飞虎");
        account.setAge(23);
        account.setBalance(300);

        accountService.save(account);
    }
}
