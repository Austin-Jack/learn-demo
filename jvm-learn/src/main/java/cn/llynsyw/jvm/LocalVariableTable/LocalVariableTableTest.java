package cn.llynsyw.jvm.LocalVariableTable;

public class LocalVariableTableTest {
    public static void main(String[] args) {

    }

    public static void test1() {
        int i = 0;
        LocalVariableTableTest example = new LocalVariableTableTest();
        int k = i;
    }
}
