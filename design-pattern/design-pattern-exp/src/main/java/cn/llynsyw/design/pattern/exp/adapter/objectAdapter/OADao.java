package cn.llynsyw.design.pattern.exp.adapter.objectAdapter;

/*���ݿ������*/
public class OADao {
    public void storePassword(String password) {
        System.out.println("��������:" + password);
    }


    public void storeEmail(String email) {
        System.out.println("��������:" + email);
    }
}
