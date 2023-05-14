package cn.llynsyw.design.pattern.exp.adapter.classAdapter;


/*��������*/
public class Adapter extends Encryption implements OADao {

    public Adapter() {
        super();
    }

    @Override
    public void storePassword(String password) {
        String encryptedPassword = PasswordEncryption(password);
        System.out.println("�������룺" + encryptedPassword);
    }

    @Override
    public void storeEmail(String email) {
        String encryptedEmail = PasswordEncryption(email);
        System.out.println("�������䣺" + encryptedEmail);
    }
}
