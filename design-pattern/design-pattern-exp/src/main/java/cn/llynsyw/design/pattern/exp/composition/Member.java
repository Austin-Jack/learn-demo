package cn.llynsyw.design.pattern.exp.composition;


public class Member extends Component {
    private String dynamicInfo;
    private String name;

    @Override
    public void add(Component component) {
        // TODO: implement
    }

    @Override
    public void remove(Component component) {
        // TODO: implement
    }

    @Override
    public void share(Component component) {
        /*如果分享的是群聊*/
        if (component instanceof Group) {
            Group group = (Group) component;
            group.share(this);
        } else {
            System.out.println(name + " share to: " + component + " info:" + dynamicInfo);
        }
    }

    public Member(String name, String dynamicInfo) {
        this.dynamicInfo = dynamicInfo;
        this.name = name;
    }

    public Member(String name) {
        this.name = name;
        this.dynamicInfo = "这个人很懒~没留下什么";
    }

    @Override
    public String toString() {
        return name;
    }
}