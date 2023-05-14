package cn.spring.test.controller;

import cn.spring.test.service.RoleService;
import cn.spring.test.service.UserService;
import cn.spring.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView listUser(ModelAndView modelAndView) {
        modelAndView.setViewName("user-list");
        modelAndView.addObject(userService.findAll());
        return modelAndView;
    }

    @RequestMapping("/getRoles")
    public ModelAndView getAllRoles(ModelAndView modelAndView) {
        modelAndView.setViewName("user-add");
        modelAndView.addObject(roleService.roleList());
        return modelAndView;
    }

    @RequestMapping("/addUser")
    public String addUser(User user,Long[] roleIds) {
        userService.addUser(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/delUser/{userId}")
    public String delUser(@PathVariable("userId") Long userId) {
        userService.delUser(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username,password);
        if(user != null ){
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
