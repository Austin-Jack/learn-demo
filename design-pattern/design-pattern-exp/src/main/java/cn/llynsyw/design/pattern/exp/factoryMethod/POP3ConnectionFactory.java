package cn.llynsyw.design.pattern.exp.factoryMethod;

public class POP3ConnectionFactory implements NetworkProtocolFactory{
    @Override
    public NetworkProtocol build() {
        return new POP3Connection();
    }
}
