package cn.llynsyw.java.curriculum.chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    //������
    public static void main(String[] args) throws IOException {
        int i;
        FileInputStream fin;  //�ļ�����������
        FileOutputStream fout;//�ļ����������
        //Ϊfinʵ������ָ����ļ���Ϊ"myfile.txt"
        fin=new FileInputStream("myfile.txt");
        //Ϊfoutʵ����,ָ���ļ���Ϊ"yourfile.txt"
        fout=new FileOutputStream("yourfile.txt");
        do{
            i=fin.read(); //��fin�����ж�ȡһ���ֽ�
            if(i!=-1)
                fout.write(i); //��������ֽ�д�����������
        }while (i!=-1);//�����ļ���β��
        //�ر�������
        fin.close();
        fout.close();
        System.out.println("myfile.txt�����Ѿ������Ƶ�yourfile.txt");
    }
}
