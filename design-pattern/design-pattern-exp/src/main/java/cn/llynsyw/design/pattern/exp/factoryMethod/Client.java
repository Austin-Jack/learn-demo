package cn.llynsyw.design.pattern.exp.factoryMethod;

import cn.llynsyw.design.pattern.exp.utils.XMLUtil;

public class Client {
    public static void main(String[] args) {
        NetworkProtocol network = null;
        NetworkProtocolFactory networkFactory =null;

        networkFactory =
                    (NetworkProtocolFactory) XMLUtil.getBean("factoryMethod.xml");
        if(networkFactory != null) {
            network = networkFactory.build();
            network.connect();
        }

    }
}
