package cn.llynsyw.design.pattern.exp.command;

/**
 * @Description ң������
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class Controller {
	private static final int SLOTS_NUM = 5;
	private AbstractCommand[] slots;

	public Controller(AbstractCommand[] slots) {
		if (slots.length > SLOTS_NUM) {
			throw  new IllegalStateException("���鳤�ȳ��������:" + SLOTS_NUM);
		}
		this.slots = slots;
		System.out.println(this.slots.length + "����۱�ָ������");
	}

	public void controlSlotN(int n) {
		if (n >= this.slots.length) {
			System.out.println("�����ڸò��:" + n);
		}else {
			slots[n].execute();
		}
	}


}
