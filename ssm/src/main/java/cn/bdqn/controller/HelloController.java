package cn.bdqn.controller;

import cn.bdqn.domain.Account;
import cn.bdqn.service.AccountService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/queryAll")
    public List<Account> queryAll(){
        List<Account> accounts = accountService.queryAll();
        return accounts;
    }

    @GetMapping(value = "/save")
    public Map<String,Object> save(){

        Account account = new Account();
        account.setName("鲍庆勇");
        account.setAge(31);
        account.setBalance(600);

        accountService.save(account);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code" , 200);
        map.put("message" , "保存成功");
        map.put("data",null);

        return map;
    }

	@GetMapping(value = "/baoqingyong")
    public ModelAndView baoqingyong(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")
                    Integer currentPage){

        PageInfo<Account> pageInfo = accountService.queryAllByPage(currentPage,5);

		// 鲍庆勇的代码

        return mv;
    }

    @GetMapping(value = "/queryAllByPage")
    public ModelAndView queryAllByPage(
            @RequestParam(name = "pageNum",required = false,defaultValue = "1")
                    Integer currentPage){

        PageInfo<Account> pageInfo = accountService.queryAllByPage(currentPage,5);

        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("list");

        return mv;
    }
}
