package cn.llynsyw.design.pattern.exp.singleton.doubleCheck;
/*˫������ⵥ��*/
public class VirtualUserGenerator {
    private static VirtualUserGenerator instance=null;

    private VirtualUserGenerator(){}
    public static VirtualUserGenerator getInstance() {
        if(instance == null) {
            synchronized (VirtualUserGenerator.class){
                if(instance == null) {
                    instance = new VirtualUserGenerator();
                }
            }
        }
        return instance;
    }
}