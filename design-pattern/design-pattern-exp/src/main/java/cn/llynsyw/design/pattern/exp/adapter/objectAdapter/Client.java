package cn.llynsyw.design.pattern.exp.adapter.objectAdapter;

import cn.llynsyw.design.pattern.exp.utils.XMLUtil;
/*�ͻ�����*/
public class Client {
    public static void main(String[] args) {

        OADao oa = (OADao) XMLUtil.getBean("adapter.xml");
        if (oa != null) {
            oa.storeEmail("123@qq.com");
            oa.storePassword("qwe123");
        }
    }
}
