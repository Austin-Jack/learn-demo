package cn.llynsyw.bigdata.mapreduce.joinOnReducer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/21
 **/
public class OrderMapper extends Mapper<LongWritable, Text, Text, OrderBean> {
	private final Text OUT_KEY = new Text();
	private final OrderBean OUT_VALUE = new OrderBean();
	private String PATH_NAME;

	@Override
	protected void setup(Mapper<LongWritable, Text, Text, OrderBean>.Context context) throws IOException,
			InterruptedException {
		this.PATH_NAME = ((FileSplit) context.getInputSplit()).getPath().getName();
	}

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, OrderBean>.Context context) throws IOException, InterruptedException {
		String line = value.toString();
		String[] split = line.split("\t");
		if (PATH_NAME.contains("order")) {
			OUT_KEY.set(split[1]);
			OUT_VALUE.setOrderId(split[0]);
			OUT_VALUE.setProductName("");
			OUT_VALUE.setAmount(Integer.valueOf(split[2]));
			OUT_VALUE.setFlag("order");
		} else {
			OUT_KEY.set(split[0]);
			OUT_VALUE.setOrderId("");
			OUT_VALUE.setProductName(split[1]);
			OUT_VALUE.setAmount(0);
			OUT_VALUE.setFlag("pd");
		}
		context.write(OUT_KEY, OUT_VALUE);
	}
}
