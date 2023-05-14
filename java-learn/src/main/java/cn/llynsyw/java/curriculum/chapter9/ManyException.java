package cn.llynsyw.java.curriculum.chapter9;

public class ManyException {
    //������
    public static void main(String[] args) {
        int i;
        int a[]={1,2,3,4};//����a[]������4��Ԫ��

        for (i = 0; i < 5; i++) { //ѭ��5��
            try {
                System.out.print("a["+i+"]/"+"i"+"="+(a[i]/i));//���a[i]/i ��һ��Ϊa[0]/0
            }
            catch(ArrayIndexOutOfBoundsException e)//��������Խ���쳣
            {
                System.out.print("�����������±�Խ���쳣");
            }
            catch(ArithmeticException e)//���������쳣
            {
                System.out.println("�쳣��������:"+e);
            }
            catch(Exception e)
            {
                System.out.printf("����"+e.getMessage()+"�쳣");
            }
            finally {
                //���i
                System.out.println("  finally i="+i);
            }
        }
        System.out.println("����!!");
    }
}
