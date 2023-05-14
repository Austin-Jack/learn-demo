package cn.llynsyw.web.extend.struts.action;

import cn.llynsyw.web.extend.struts.beans.User;
import cn.llynsyw.web.extend.struts.service.UserService;
import cn.llynsyw.web.extend.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class LoginActionWithSupport extends ActionSupport {
    UserService userService=new UserServiceImpl();
    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        User user=new User(userName,userPassword);
        user=userService.checkUser(user);
        if (user!=null) {
            session.put("UserId", user.getId());
            return SUCCESS;
        }else {
            request.put("message","不存在该用户");
        }
        return ERROR;
    }

    @Override
    public void validate() {
        if ("".equals(userName)) {
            addFieldError("userName", "用户名不能为空");
        }
        if ("".equals(userPassword)) {
            addFieldError("userPassword", "用户密码不能为空");
        }
    }
}
