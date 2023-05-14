package cn.llynsyw.web.extend.struts.action;

public class HelloWorld {
    public final static String MESSAGE="Hello structs2";
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String execute() throws Exception{
        setMessage(MESSAGE);
        return  "success";
    }
}
