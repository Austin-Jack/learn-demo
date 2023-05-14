package cn.llynsyw.design.pattern.exp.factoryMethod;

public class HTTPConnection implements NetworkProtocol{
    @Override
    public void connect() {
        System.out.println("������һ��HTTP����");
    }
}
