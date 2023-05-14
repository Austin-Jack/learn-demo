package cn.llynsyw.design.pattern.exp.factoryMethod;

public class IMAPConnection implements NetworkProtocol{
    @Override
    public void connect() {
        System.out.println("������һ��IMAP����");
    }
}
