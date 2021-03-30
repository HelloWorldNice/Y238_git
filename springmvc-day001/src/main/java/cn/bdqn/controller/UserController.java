package cn.bdqn.controller;

import cn.bdqn.domain.Address;
import cn.bdqn.domain.User;
import cn.bdqn.reponse.ResponseResult;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        dateFormat.setLenient(false); // 严格按照指定的格式进行解析
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }

    // 绑定基本数据类型+String
    @RequestMapping(value = "/register")
    public void register(String username,String password,int age){
        System.out.println(username);
        System.out.println(password);
        System.out.println(age);
    }

    // 绑定实体类型
    @RequestMapping(value = "/registerDomain")
    public void registerDomain(User user){
        System.out.println(user);
    }

    // 绑定实体类型 + 关联实体
    @RequestMapping(value = "registerDomainAndRelation")
    public void registerDomainAndRelation(User user){
        System.out.println(user);
    }

    // 绑定实体类型 + List
    @RequestMapping(value = "/registerDomainAndList")
    public void registerDomainAndList(User user){
        for (Address address:user.getAddressList()) {
            System.out.println(address);
        }
    }



    // 绑定实体类型 + List
    @RequestMapping(value = "/registerDomainAndMap")
    public void registerDomainAndMap(User user){
        System.out.println(user);

        Map<String,Address> map = user.getAddressMap();
        Set<Map.Entry<String,Address>> entrySet = map.entrySet();
        for (Map.Entry<String,Address> entry: entrySet) {
            String key = entry.getKey();
            Address address = entry.getValue();
            System.out.println("key-->" + key);
            System.out.println("value-->" + address);
        }
    }

    // 绑定基本数据类型+String
    @RequestMapping(value = "/registerDomainAndDate")
    public void registerDomainAndDate(User user){
        System.out.println(user);
    }

    //
    @RequestMapping(value = "/testRequestParam")
    public void testRequestParam(
            @RequestParam(value = "username",required = false,defaultValue = "Tomcat")
            String name){
        System.out.println(name);
    }

    @RequestMapping(value = "/testRequestBody")
    public void testRequestBody(@RequestBody String content){
        System.out.println(content);
    }

    // 处理模型数据---原生态的方式
    @RequestMapping(value = "/handleModelData1")
    public void handleModelData1(HttpServletRequest request,HttpServletResponse response) throws Exception{

        User user = new User();
        user.setUsername("杨凌破");
        user.setAge(21);
        user.setBorn(new Date());

        List<Address> addressList = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河南省");
        address1.setCity("安阳");

        Address address2 = new Address();
        address2.setProvince("浙江省");
        address2.setCity("杭州");

        addressList.add(address1);
        addressList.add(address2);

        user.setAddressList(addressList);

        request.setAttribute("user",user);

        request.getRequestDispatcher("/WEB-INF/jsp/userinfo.jsp").forward(request,response);
    }

    // 处理模型数据---方法的形参使用Map类型
    @RequestMapping(value = "/handleModelData2")
    public String handleModelData2(Map<String,Object> map){

        User user = new User();
        user.setUsername("鲍庆勇");
        user.setAge(21);
        user.setBorn(new Date());

        List<Address> addressList = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河南省");
        address1.setCity("安阳");

        Address address2 = new Address();
        address2.setProvince("浙江省");
        address2.setCity("杭州");

        addressList.add(address1);
        addressList.add(address2);

        user.setAddressList(addressList);

        map.put("user" , user);

        return "userinfo";
    }

    // 处理模型数据---方法的形参使用Map类型
    @RequestMapping(value = "/handleModelData3")
    public String handleModelData3(Model model){

        User user = new User();
        user.setUsername("靳梦超");
        user.setAge(21);
        user.setBorn(new Date());

        List<Address> addressList = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河南省");
        address1.setCity("安阳");

        Address address2 = new Address();
        address2.setProvince("浙江省");
        address2.setCity("杭州");

        addressList.add(address1);
        addressList.add(address2);

        user.setAddressList(addressList);

        model.addAttribute("user",user);

        return "userinfo";
    }

    // 处理模型数据---方法的形参使用Map类型
    @RequestMapping(value = "/handleModelData4")
    public String handleModelData4(ModelMap modelMap){

        User user = new User();
        user.setUsername("苏宁");
        user.setAge(21);
        user.setBorn(new Date());

        List<Address> addressList = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河南省");
        address1.setCity("安阳");

        Address address2 = new Address();
        address2.setProvince("浙江省");
        address2.setCity("杭州");

        addressList.add(address1);
        addressList.add(address2);

        user.setAddressList(addressList);

        modelMap.addAttribute("user",user);

        return "userinfo";
    }

    // 处理模型数据---方法的形参使用Map类型
    @RequestMapping(value = "/handleModelData5")
    public ModelAndView handleModelData5(){

        User user = new User();
        user.setUsername("付思鑫");
        user.setAge(21);
        user.setBorn(new Date());

        List<Address> addressList = new ArrayList<>();

        Address address1 = new Address();
        address1.setProvince("河南省");
        address1.setCity("安阳");

        Address address2 = new Address();
        address2.setProvince("浙江省");
        address2.setCity("杭州");

        addressList.add(address1);
        addressList.add(address2);

        user.setAddressList(addressList);

        ModelAndView mv = new ModelAndView();
        mv.addObject("user" , user);
        mv.setViewName("userinfo");

        return mv;
    }

    @RequestMapping(value = "/userRegister")
    @ResponseBody
    public ResponseResult userRegister(User user){
        System.out.println(user);

        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setData(user);
        result.setMessage("注册成功...");

        return result;
    }

    @RequestMapping(value = "/userRegister4")
    @ResponseBody
    public ResponseResult userRegister4(@RequestBody User user){
        System.out.println(user);

        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setData(user);
        result.setMessage("....注册成功......");

        return result;
    }

    @RequestMapping(value = "/userRegister5")
    @ResponseBody
    public ResponseResult userRegister5(User user){
        System.out.println(user);

        ResponseResult result = new ResponseResult();
        result.setCode(200);
        result.setData(user);
        result.setMessage("....注册成功..****");

        return result;
    }
}
