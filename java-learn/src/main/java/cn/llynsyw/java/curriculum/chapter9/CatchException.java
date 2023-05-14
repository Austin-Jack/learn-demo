package cn.llynsyw.java.curriculum.chapter9;

import java.io.IOException;

public class CatchException {
    //������
    public static void main(String[] args) {
        System.out.println("����ʼ");
        try
        {
            System.in.read(); //�Ӽ��̶���һ���ַ�
        }
        catch (IOException e) {} //����IO�쳣

        System.out.println("�������");
    }
}
