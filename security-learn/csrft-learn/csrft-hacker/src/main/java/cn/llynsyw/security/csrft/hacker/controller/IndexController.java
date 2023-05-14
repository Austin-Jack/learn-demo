package cn.llynsyw.security.csrft.hacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/HNUPCJ/article/details/{id}")
    public String csrf(@PathVariable("id")Long id, Model model){
        model.addAttribute("redirectUrl","https://blog.csdn.net/HNUPCJ/article/details/"+id);
        return "csrft";
    }
}
