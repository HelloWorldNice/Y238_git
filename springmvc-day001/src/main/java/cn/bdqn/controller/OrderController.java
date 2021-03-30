package cn.bdqn.controller;

import cn.bdqn.domain.User;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class OrderController {

    // 响应类型，返回String,重定向
    @RequestMapping(value = "/toRedirect")
    public String toRedirect(){
        return "redirect:/login.jsp";
    }

    // 响应类型，返回String,请求转发
    @RequestMapping(value = "/toForward")
    public String toForward(){
        return "forward:/WEB-INF/jsp/main.jsp";
    }

    // 响应类型，返回String,返回字符串
    @RequestMapping(value = "/returnString" ,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String returnString(){
        return "Hello,李欣玉，鲍庆勇";
    }

    // 响应类型，返回String,返回字符串
    @RequestMapping(value = "/returnString2")
    public void returnString2(HttpServletResponse response) throws Exception{
        response.getWriter().write("QQ");
    }

    @RequestMapping(value = "/toUser")
    public void toUser(HttpServletResponse response) throws Exception{

        response.setContentType("application/json;charset=utf-8");

        User user = new User();
        user.setUsername("鲍庆勇");
        user.setAge(23);

        String result = JSONObject.toJSONString(user);

        response.getWriter().write(result);
    }

    // 如何解决乱码问题？
    @RequestMapping(value = "/toUser2",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String toUser2() throws Exception{

        User user = new User();
        user.setUsername("李欣玉");
        user.setAge(23);

        String result = JSONObject.toJSONString(user);

        return result;
    }

    // 思想是可以的，是可以直接返回User对象的，此程序目前来说是有小问题
    // 缺少类型转换器，意味着如果有这么一个返回对象的类型转换器就可以了。
    @RequestMapping(value = "/toUser3")
    @ResponseBody
    public User toUser3() throws Exception{

        User user = new User();
        user.setUsername("靳梦超");
        user.setAge(23);

        return user;
    }

}
