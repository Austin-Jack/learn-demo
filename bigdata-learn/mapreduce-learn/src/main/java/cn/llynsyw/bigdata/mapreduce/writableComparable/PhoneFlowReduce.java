package cn.llynsyw.bigdata.mapreduce.writableComparable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/19
 **/
public class PhoneFlowReduce extends Reducer<FlowBean, Text, Text, FlowBean> {


	@Override
	protected void reduce(FlowBean key, Iterable<Text> values,
	                      Reducer<FlowBean, Text, Text, FlowBean>.Context context) throws IOException,
			InterruptedException {
		for (Text value : values) {
			context.write(value, key);
		}
	}
}
