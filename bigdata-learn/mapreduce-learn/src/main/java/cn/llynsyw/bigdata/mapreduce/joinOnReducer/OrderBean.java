package cn.llynsyw.bigdata.mapreduce.joinOnReducer;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/21
 **/
public class OrderBean implements Writable {
	private String orderId;
	private Integer amount;
	private String productName;
	private String flag;



	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public OrderBean() {
	}


	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeUTF(this.orderId);
		dataOutput.writeInt(this.amount);
		dataOutput.writeUTF(this.productName);
		dataOutput.writeUTF(this.flag);
	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.orderId = dataInput.readUTF();
		this.amount = dataInput.readInt();
		this.productName = dataInput.readUTF();
		this.flag = dataInput.readUTF();
	}

	@Override
	public String toString() {
		return this.orderId + "\t" + this.productName + "\t" + this.amount;
	}
}
