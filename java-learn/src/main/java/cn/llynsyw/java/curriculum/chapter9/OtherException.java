package cn.llynsyw.java.curriculum.chapter9;

public class OtherException {
    //������
    public static void main(String[] args) {
        try {
            int a[]=null;
            a[0]=1;//�׳�NullPointerException�쳣
        }
        catch (NullPointerException e)
        {
            System.out.println("��ָ���쳣");
        }
        try {
            String str=null;
            str.length();//�׳�NullPointerException�쳣
        }
        catch (NullPointerException e)
        {
            System.out.println("��ָ���쳣");
        }
        try
        {
            Object obj=new Object();
            String str=(String)obj;//�׳�ClassCastException�쳣
        }
        catch (ClassCastException e)
        {
            System.out.println("����ǿ��ת���쳣");
        }
        try {
            int a[]=new int[-1];//�׳�NegativeArraySizeException�쳣
        }
        catch (NegativeArraySizeException e) {
            System.out.println("���鸺�±��쳣");
        }
        try
        {
            int a[]=new int [1];
            a[0]=0;
            a[1]=1;//�׳�ArrayIndexOutOfBoundsException�쳣
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("�����±�Խ���쳣");
        }
    }
}
