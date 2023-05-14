package cn.llynsyw.java.task.week01.day06.someKeywords.abstractdemo;

public abstract class AbstractDemo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractDemo(){}

    public abstract void function();
}

class Test extends AbstractDemo{

    @Override
    public void function() {

    }
}