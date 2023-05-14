package cn.llynsyw.web.extend.struts.action;

import com.opensymphony.xwork2.ActionContext;

public class LogOut {
    public String execute() throws Exception{
        ActionContext.getContext().getSession().remove("UserId");
        return "success";
    }
}
