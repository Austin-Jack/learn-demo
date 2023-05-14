package cn.llynsyw.spring.mvc;

import cn.llynsyw.spring.mvc.pojo.User;
import cn.llynsyw.spring.mvc.pojo.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "/test1", method = RequestMethod.GET, params = {"username"}) //指定访问必须带有该参数
    public String save() {
        System.out.println("Controller save running ..");
        //相对当前资源的地址
        //return "success.jsp";
        //return "/success.jsp"; //绝对地址
        //    return "forward:success.jsp"; 其实省略了转发前缀 也是默认为转发
        //    return "redirect:success.jsp"; 如果需要重定向则需要这样

        //return "/jsp/success.jsp"; //如果没有配置视图解析器的前后缀
        return "success";           /*配置后除去前缀jsp/和后缀.jsp*/
    }


    @RequestMapping(value = "/test2")
    public ModelAndView test2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "lly");
        return modelAndView;
    }

    /*自动注入*/
    @RequestMapping(value = "/test3")
    public ModelAndView test3(ModelAndView modelAndView) {
        modelAndView.setViewName("success");
        modelAndView.addObject("username", "test3");
        return modelAndView;
    }

    @RequestMapping(value = "/test4")
    public String test4(Model model) {
        model.addAttribute("username", "test4");
        return "success";
    }

    /*自动注入request*/
    @RequestMapping(value = "test5")
    public String test5(HttpServletRequest request) {
        request.setAttribute("username", "test5");
        return "success";
    }

    @RequestMapping(value = "test6")
    public void test6(HttpServletResponse response) throws IOException {
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().println("回写字符串");
    }

    @RequestMapping(value = "test7")
    @ResponseBody /*告诉springmvc不要跳转视图而是回写字符串*/
    public String test7() {
        return "write a string";
    }

    @RequestMapping(value = "test8")
    @ResponseBody
    public User test8() {
        return new User("lly", 21);
    }

    @RequestMapping(value = "/test9")
    @ResponseBody
    public void test9(User user) {
        System.out.println(user);
    }

    @RequestMapping(value = "/test10")
    @ResponseBody
    public void test10(String[] strings) {
        System.out.println(Arrays.asList(strings));
    }


    /*获取集合封装到Vo 对象中 只要对象中的集合属性名称与传入的表单中一致即可自动注入*/
    @RequestMapping(value = "/test11")
    @ResponseBody
    public void test11(Vo vo) {
        System.out.println(vo.getUserList());
    }

    @RequestMapping(value = "/test12")
    @ResponseBody
    public List<User> test12(@RequestBody List<User> userList) {
        System.out.println(userList);
        return userList;
    }

    @RequestMapping("/test13/{name}")
    public void test13(@PathVariable(value = "name") String name) {
        System.out.println(name);
    }

    @RequestMapping("/test14")
    public void test14(Date date) {
        System.out.println(date);
    }

    /*获取请求头*/
    @RequestMapping("/test15")
    public String test15(@RequestHeader(value = "User-Agent") String userAgent) {
        System.out.println(userAgent);
        return "success";
    }
    /*获取cookie*/
    @RequestMapping("/test16")
    public String test16(@CookieValue("JSESSIONID") String jessionid) {
        System.out.println(jessionid);
        return "success";
    }

    @RequestMapping("/upload")
    public String upload(String username, MultipartFile uploadFile) throws IOException {
        //获取上传文件名称
        String filename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("D:\\IdeaProjects\\learn_demo\\spring_mvc\\upload\\" + username + filename));
        return "success";
    }

    @RequestMapping("/uploadMultiple")
    public String uploadMultiple(String username, MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile uploadFile : uploadFiles) {
            uploadFile.transferTo(new File("D:\\IdeaProjects\\learn_demo\\spring_mvc\\upload\\" + username + uploadFile.getOriginalFilename()));
        }
        return "success";
    }
}
