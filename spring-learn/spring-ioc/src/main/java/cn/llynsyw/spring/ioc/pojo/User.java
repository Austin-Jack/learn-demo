package cn.llynsyw.spring.ioc.pojo;

import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private List<Object> friends;
    private Map<String, User> friendsMap;


    public User() {
    }

    public User(String name, int age, List<Object> friends, Map<String, User> friendsMap) {
        this.name = name;
        this.age = age;
        this.friends = friends;
        this.friendsMap = friendsMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Object> getFriends() {
        return friends;
    }

    public void setFriends(List<Object> friends) {
        this.friends = friends;
    }

    public Map<String, User> getFriendsMap() {
        return friendsMap;
    }

    public void setFriendsMap(Map<String, User> friendsMap) {
        this.friendsMap = friendsMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + friends +
                ", friendsMap=" + friendsMap +
                '}';
    }
}
