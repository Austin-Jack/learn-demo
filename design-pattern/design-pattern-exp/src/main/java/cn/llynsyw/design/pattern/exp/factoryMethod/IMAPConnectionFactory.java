package cn.llynsyw.design.pattern.exp.factoryMethod;

public class IMAPConnectionFactory implements NetworkProtocolFactory{
    @Override
    public NetworkProtocol build() {
        return new IMAPConnection();
    }
}
