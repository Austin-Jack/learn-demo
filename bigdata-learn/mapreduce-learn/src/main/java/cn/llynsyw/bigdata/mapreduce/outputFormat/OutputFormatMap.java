package cn.llynsyw.bigdata.mapreduce.outputFormat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/20
 **/
public class OutputFormatMap extends Mapper<LongWritable, Text, Text, NullWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context) throws IOException, InterruptedException {
		context.write(value, NullWritable.get());
	}
}
