package cn.llynsyw.design.pattern.exp.singleton.hungryType;

/*����ʽ����ģʽ*/
public class VirtualUserGenerator {
    private static VirtualUserGenerator instance = new VirtualUserGenerator();

    private VirtualUserGenerator() {
    }

    public static VirtualUserGenerator getInstance() {
        return instance;
    }
}
