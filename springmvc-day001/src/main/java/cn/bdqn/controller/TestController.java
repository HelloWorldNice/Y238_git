package cn.bdqn.controller;

import cn.bdqn.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // @Controller  + @ResponseBody
public class TestController {

    //@RequestMapping(value = "/hello" , method = RequestMethod.GET)
    @GetMapping("/hello")
    public String hello() throws MyException{
        int x = 1 / 0;
        return "hello,world";
    }
}
