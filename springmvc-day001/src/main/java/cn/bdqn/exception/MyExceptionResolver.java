package cn.bdqn.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {

    // e： 程序发生的异常
    public ModelAndView resolveException(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Object o,
            Exception e) {

        MyException myException = null;
        if(e instanceof MyException){
            myException = (MyException) e;
        }else{
            myException = new MyException("网络繁忙，稍后再试....");
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errorMessage",myException.getMessage());

        return mv;
    }
}
