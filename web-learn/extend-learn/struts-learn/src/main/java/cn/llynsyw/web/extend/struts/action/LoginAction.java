package cn.llynsyw.web.extend.struts.action;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class LoginAction {
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

    public String execute()throws Exception{
        //默认调用了set方法设置了匹配的属性
        String message="";
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        if ("".equals(userName)||"".equals(userPassword)){
            message="用户名或密码不能为空";
            request.put("message",message);
            return "error";
        }
        if ("lly".equals(userName)&&"123".equals(userPassword)){
            ActionContext.getContext().getSession().put("userName",getUserName());
            return "success";
        }
        return "error";
    }

}
