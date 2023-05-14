package cn.llynsyw.java.task.week01.day06.someKeywords.finalDemo;


public final class FinalTest {

    private static final int a;
    private final int b = 1;

    static {
        a = Account.account;
    }

    public int getA() {
        return a;
    }

}

class Account {
    public static int account;

    public static void setAccount(int a) {
        account = a;
    }

    public static void finalTests(final int a, final int b) {
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        setAccount(999);
        System.out.println(new FinalTest().getA());
    }
}
