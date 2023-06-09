package cn.llynsyw.bigdata.mapreduce.phoneFlow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/19
 **/

public class FlowBean implements Writable {
	private Long upFlow;
	private Long downFlow;
	private Long totalFlow;

	public FlowBean() {
	}

	public Long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(Long upFlow) {
		this.upFlow = upFlow;
	}

	public Long getDownFlow() {
		return downFlow;
	}

	public void setDownFlow(Long downFlow) {
		this.downFlow = downFlow;
	}

	public Long getTotalFlow() {
		return totalFlow;
	}

	public void setTotalFlow() {
		this.totalFlow = this.downFlow + this.upFlow;
	}

	@Override
	public void write(DataOutput dataOutput) throws IOException {
		dataOutput.writeLong(this.upFlow);
		dataOutput.writeLong(this.downFlow);
		dataOutput.writeLong(this.totalFlow);
	}

	@Override
	public void readFields(DataInput dataInput) throws IOException {
		this.upFlow = dataInput.readLong();
		this.downFlow = dataInput.readLong();
		this.totalFlow = dataInput.readLong();
	}

	@Override
	public String toString() {
		return upFlow + "\t" + downFlow + "\t" + totalFlow;
	}
}
