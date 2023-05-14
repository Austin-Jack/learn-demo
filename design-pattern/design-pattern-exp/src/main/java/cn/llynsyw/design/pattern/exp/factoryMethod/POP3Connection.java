package cn.llynsyw.design.pattern.exp.factoryMethod;

public class POP3Connection implements NetworkProtocol{
    @Override
    public void connect() {
        System.out.println("������һ��POP3����");
    }
}
