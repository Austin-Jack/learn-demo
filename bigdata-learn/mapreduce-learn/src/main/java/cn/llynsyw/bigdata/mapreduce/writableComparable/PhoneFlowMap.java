package cn.llynsyw.bigdata.mapreduce.writableComparable;

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
public class PhoneFlowMap extends Mapper<LongWritable, Text, FlowBean, Text> {
	private final Text OUT_VALUE = new Text();
	private final FlowBean OUT_KEY  = new FlowBean();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FlowBean, Text>.Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String[] split = line.split("\t");
		OUT_VALUE.set(split[0]);

		OUT_KEY.setUpFlow(Long.valueOf(split[1]));
		OUT_KEY.setDownFlow(Long.valueOf(split[2]));
		OUT_KEY.setTotalFlow();

		context.write(OUT_KEY, OUT_VALUE);
	}
}
