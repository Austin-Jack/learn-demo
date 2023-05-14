package cn.llynsyw.bigdata.mapreduce.partition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/20
 **/
public class ProvincePartition extends Partitioner<Text, FlowBean> {
	@Override
	public int getPartition(Text text, FlowBean flowBean, int i) {
		String phoneNumber = text.toString();
		if (phoneNumber.startsWith("136")) {
			return 0;
		} else if (phoneNumber.startsWith("137")) {
			return 1;
		} else if (phoneNumber.startsWith("138")) {
			return 2;
		} else if (phoneNumber.startsWith("139")) {
			return 3;
		}
		return 4;
	}
}
