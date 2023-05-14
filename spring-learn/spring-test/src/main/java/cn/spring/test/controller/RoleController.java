package cn.spring.test.controller;

import cn.spring.test.service.RoleService;
import cn.spring.test.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView listRole(ModelAndView modelAndView) {
        modelAndView.setViewName("role-list");
        modelAndView.addObject(roleService.roleList());
        return modelAndView;
    }

    @RequestMapping("/add")
    public String addRole(Role role) {
        roleService.addRole(role);
        return "redirect:/role/list";
    }
}
