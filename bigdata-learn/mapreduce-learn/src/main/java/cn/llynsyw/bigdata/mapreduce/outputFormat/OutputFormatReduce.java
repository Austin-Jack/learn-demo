package cn.llynsyw.bigdata.mapreduce.outputFormat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/20
 **/
public class OutputFormatReduce extends Reducer<Text, NullWritable, Text, NullWritable> {
	@Override
	protected void reduce(Text key, Iterable<NullWritable> values,
	                      Reducer<Text, NullWritable, Text, NullWritable>.Context context) throws IOException,
			InterruptedException {
		for (NullWritable value : values) {
			context.write(key, value);
		}
	}
}
