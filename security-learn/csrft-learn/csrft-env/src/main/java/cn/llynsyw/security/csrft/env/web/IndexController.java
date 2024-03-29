package cn.llynsyw.security.csrft.env.web;

import cn.llynsyw.security.csrft.env.entity.UserEntity;
import cn.llynsyw.security.csrft.env.vo.ExchangeVo;
import cn.llynsyw.security.csrft.env.service.UserService;
import cn.llynsyw.security.csrft.env.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @GetMapping("/qq")
    public String qqPage(){
        return "qq";
    }

    @GetMapping("/act/a20130522cdkey")
    public String qqspeedPage(){
        return "qqspeed";
    }

    @PostMapping("/login")
    public String login(UserEntity userEntity, HttpSession session, RedirectAttributes redirectAttributes){
        UserEntity user = userService.login(userEntity);
        if(user==null){
            redirectAttributes.addFlashAttribute("msg","用户名或密码错误");
            return "redirect:/qq";
        }else{
            session.setAttribute("user",user);
            return "redirect:/act/a20130522cdkey";
        }
    }

    @ResponseBody
    @GetMapping("/exchange")
    public R exchange(ExchangeVo exchangeVo, HttpSession session){
        UserEntity user =(UserEntity) session.getAttribute("user");
        if(user==null)
            return R.error("请先登录");
        exchangeVo.setSenderQQ(user.getUsername());
        try{
            userService.exchange(exchangeVo);
            return R.ok();
        }catch (Exception e){
            return R.error(e.getMessage());
        }
    }

    @RequestMapping("/csrf.html")
    public String csrf(){
        return "csrf";
    }
}
