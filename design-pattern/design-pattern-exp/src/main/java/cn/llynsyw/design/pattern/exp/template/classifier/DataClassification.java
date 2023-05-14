package cn.llynsyw.design.pattern.exp.template.classifier;

/**
 * @Description
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public abstract class DataClassification {
	StringBuilder dataBuffer;

	protected DataClassification() {
		dataBuffer = new StringBuilder();
	}

	protected void readData() {
		System.out.println("readData....");
		dataBuffer.append("������������rap");
	}

	protected void transformData() {
		System.out.println("transformData...");
	}

	protected abstract void classify();

	protected void display() {
		System.out.println("display��" + "����");
	}

	public void process() {
		readData();
		transformData();
		classify();
		display();
	}
}
