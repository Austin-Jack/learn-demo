package cn.llynsyw.java.curriculum.chapter9;

public class MethodException {
    static void m() throws Exception //�÷����׳�Exception�쳣
    {
        int a=3;
        int b=0;
        int c=a/b; //���׳��쳣
        System.out.println(a+"/"+b+"="+c);//�����ʾ���
    }

    public static void main(String[] args) {
        try {
            m(); //���Ե���m()����
        }catch (Exception e)//�����������
        {
            //��ʾ�쳣��Ϣ
            System.out.println("����"+e.getMessage()+"�쳣��");
        }
        System.out.println("�������");
    }
}
