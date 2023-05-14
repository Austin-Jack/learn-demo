package cn.llynsyw.web.extend.struts.action;

import cn.llynsyw.web.extend.struts.beans.User;
import cn.llynsyw.web.extend.struts.service.UserService;
import cn.llynsyw.web.extend.struts.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class RegisterAction extends ActionSupport {
    UserService userService=new UserServiceImpl();
    private String userName;
    private String userPassword;
    private String confirmPassword;

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String execute() throws Exception {
        String message="";

        Map<String,Object> request= (Map<String, Object>) ActionContext.getContext().get("request");
        User user=new User(userName,userPassword);
        if(userService.insertUser(user)){
           return SUCCESS;
        }
        message="已存在该用户";
        request.put("message",message);
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
        if (!userPassword.equals(confirmPassword)){
            addFieldError("confirmPassword","两次密码不匹配");
        }
    }
}
