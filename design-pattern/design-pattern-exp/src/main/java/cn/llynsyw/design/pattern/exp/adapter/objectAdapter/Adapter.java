package cn.llynsyw.design.pattern.exp.adapter.objectAdapter;

/*����������*/
public class Adapter extends OADao {
	private Encryption enr;

	public Adapter() {

	}

	public Adapter(Encryption enr) {
		this.enr = enr;
	}


	@Override
	public void storePassword(String password) {
		String enCryptPassword = enr.encryptedPassword(password);
		super.storePassword(enCryptPassword);
	}

	@Override
	public void storeEmail(String email) {
		String enEmail = enr.encryptedEmail(email);
		super.storeEmail(enEmail);
	}
}
