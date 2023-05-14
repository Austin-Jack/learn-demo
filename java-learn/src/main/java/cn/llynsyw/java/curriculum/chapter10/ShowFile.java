package cn.llynsyw.java.curriculum.chapter10;

import java.io.FileInputStream;
import java.io.IOException;

public class ShowFile {
    //������
    public static void main(String[] args) throws IOException { //���봦���IO�쳣
        int i;
        FileInputStream fin; //�ļ�����������
        //ʵ����fin,ָ����ļ���Ϊ"myfile.txt"
        fin=new FileInputStream("myfile.txt");
        do {
            i=fin.read(); //��һ���ֽ�
            if(i!=-1)  //������ַ�Ϊ�����������
                System.out.print((char) i);
        }while(i!=-1);//�����ļ���β
        fin.close();
    }
}
