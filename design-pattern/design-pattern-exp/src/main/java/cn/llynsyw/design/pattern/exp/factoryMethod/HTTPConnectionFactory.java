package cn.llynsyw.design.pattern.exp.factoryMethod;

public class HTTPConnectionFactory implements NetworkProtocolFactory {
    @Override
    public NetworkProtocol build() {
        return new HTTPConnection();
    }
}
