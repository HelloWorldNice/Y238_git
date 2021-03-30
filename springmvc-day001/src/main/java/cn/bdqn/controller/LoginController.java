package cn.bdqn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    // 处理用户请求的方法
    // http:localhost:9090/springmvc-day001/login

    @RequestMapping(value = "/login" ,
            method = RequestMethod.GET,
            params = {"username=yyy"}
    )
    public String login(){
        // /WEB-INF/jsp/main.jsp // 物理视图
        System.out.println("---LoginController--login---");
        return "main"; // 逻辑视图名
    }
}
