package cn.llynsyw.web.curriculum.exp_6.beans;

public class UserBean {
    private String name;
    private String password;

    public UserBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserBean(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
