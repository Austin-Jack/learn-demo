package cn.llynsyw.design.pattern.exp.command;

/**
 * @Description ����ĵ���
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class RoomLight {
	private String name;
	private boolean state;

	public RoomLight(String name) {
		this.name = name;
		this.state = false;
	}

	public boolean getState() {
		return this.state;
	}

	public void turnOn() {
		state = true;
		System.out.println("����: " + this.name + " �ĵƱ���");
	}

	public void turnOff() {
		state = false;
		System.out.println("����: " + this.name + " �ĵƱ��ر�");
	}
}
