package cn.llynsyw.java.basic.day05.demo02;


/*
向上转型是为了多态
向下转型的用处：用于调用子类中的特有的方法
而instanceof是用来检测向下转换后的对象是否想要的子类的一个对象，再去通过该对象调用类中的特有方法

而向上转型又向下转型 并不是没用
这样组合使用就可以在那些对象类型未知的情况下分别具体调用
 */
public class Demo03Instanceof {
    public static void main(String[] args) {
        Animal cat=new Cat();//多态,父类引用指向子类
        unique(cat);
    }
    public static  void unique(Animal animal){
        if (animal instanceof Cat){
            ((Cat) animal).characterOfCat();
        }
        if (animal instanceof Dog){
            ((Dog) animal).characterOfDog();
        }
    }
}
