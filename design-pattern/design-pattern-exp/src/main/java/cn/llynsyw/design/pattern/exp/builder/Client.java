package cn.llynsyw.design.pattern.exp.builder;

import cn.llynsyw.design.pattern.exp.utils.XMLUtil;
/*�ͻ���*/
public class Client {
    public static void main(String[] args) {
        /*��̬ȷ����������*/
        CarBuilder carBuilder = (CarBuilder) XMLUtil.getBean("builder.xml");
        /*ָ����*/
        Director director = new Director();
        /*���ý�����*/
        director.setCarBuilder(carBuilder);

        Car car = director.Construct();

        System.out.println("���� :  " + car.getBody());
        System.out.println("��̥ :  " + car.getTire());
        System.out.println("���� :  " + car.getEngine());
        System.out.println("������: " + car.getGearbox());

    }
}
