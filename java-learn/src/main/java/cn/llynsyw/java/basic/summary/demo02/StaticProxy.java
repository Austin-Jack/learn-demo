package cn.llynsyw.java.basic.summary.demo02;

//结婚接口
interface Marry {
    void happyMarry();
}

//真实角色
class Person implements Marry {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void happyMarry() {
        System.out.println("恭喜" + name + "要结婚了！");
    }
}

//婚庆公司，代理角色
class WeddingCompany implements Marry {
    //真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();//通过真实对象调用
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前,布置");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        Person p=new Person("Rachel"); //真实对象
        WeddingCompany weddingCompany = new WeddingCompany(p);//给婚庆公司代理
        weddingCompany.happyMarry();
    }
}
