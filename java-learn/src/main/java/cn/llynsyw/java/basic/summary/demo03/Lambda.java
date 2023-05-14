package cn.llynsyw.java.basic.summary.demo03;

public class Lambda {

    //静态内部类
    static class LambdaLambdaImplements2 implements LambdaInterface
    {
        @Override
        public void lambda() {
            System.out.println("我是静态内部实现类");
        }
    }

    public static void main(String[] args) {
        //常规调用
        LambdaInterface l=new LambdaImplements();
        l.lambda();

        //静态内部类调用
        l=new LambdaLambdaImplements2();
        l.lambda();

        //局部内部类
        class LambdaImplements3 implements LambdaInterface{
            @Override
            public void lambda() {
                System.out.println("我是局部内部实现类");
            }
        }
        //局部内部类调用
        l=new LambdaImplements3();
        l.lambda();

        //匿名内部类
        l=new LambdaInterface() {
            @Override
            public void lambda() {
                System.out.println("我是匿名实现内部类");
            }
        };
        l.lambda();

        //Lambda表达式
        l=()-> {
            System.out.println("我是Lambda表达式");
        };
        l.lambda();

    }
}


//定义一个函数式接口 也就是只有一个抽象方法的接口
interface LambdaInterface{
    void lambda();
}

//实现接口
class LambdaImplements implements LambdaInterface
{
    @Override
    public void lambda() {
        System.out.println("我是常规实现类");
    }
}