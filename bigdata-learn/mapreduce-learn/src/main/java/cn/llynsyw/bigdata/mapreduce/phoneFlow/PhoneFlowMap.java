package cn.llynsyw.bigdata.mapreduce.phoneFlow;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * 输入格式：
 * 1	13736230513	192.196.100.1	www.atguigu.com	2481	24681	200
 * 2	13846544121	192.196.100.2			264	0	200
 *
 * @author luolinyuan
 * @date 2023/1/19
 **/
public class PhoneFlowMap extends Mapper<LongWritable, Text, Text, FlowBean> {
	private final Text OUT_KEY = new Text();
	private final FlowBean OUT_VALUE = new FlowBean();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {
		String[] data = value.toString().split("\t");
		OUT_KEY.set(data[1]);
		OUT_VALUE.setUpFlow(Long.valueOf(data[data.length - 3]));
		OUT_VALUE.setDownFlow(Long.valueOf(data[data.length - 2]));
		OUT_VALUE.setTotalFlow();

		context.write(OUT_KEY, OUT_VALUE);
	}
}
