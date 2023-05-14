package cn.llynsyw.bigdata.mapreduce.outputFormat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/20
 **/
public class LogPartition extends Partitioner<Text, NullWritable> {
	@Override
	public int getPartition(Text text, NullWritable nullWritable, int i) {
		String str = text.toString();
		if (str.contains("atguigu")) {
			return 0;
		}
		return 1;
	}
}
