package cn.llynsyw.java.curriculum.chapter9;

class AaaException extends Exception{} //AaaException��̳���Exception��

class BbbException extends Exception{} //BbbException��̳���Exception��

public class ThrowException {
    //������
    public static void main(String[] args) {
        int x=1;
        try
        {
            if(x>0)
                throw new AaaException();  //�׳�AaaException��һ��ʵ��
            else
                throw new BbbException();  //�׳�BbbException��һ��ʵ��
        } catch (AaaException e) {
            System.out.println("ִ��aaa�쳣�������");
        }
        catch (BbbException e)
        {
            System.out.println("ִ��bbb�쳣�������");
        }
    }
}
