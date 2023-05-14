package cn.llynsyw.bigdata.mapreduce.wordCount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/19
 **/
public class WordCountReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
	private int count;
	private final IntWritable OUT_VALUE = new IntWritable();

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
	                      Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException,
			InterruptedException {
		count = 0;
		for (IntWritable value : values) {
			count += value.get();
		}
		OUT_VALUE.set(count);
		context.write(key, OUT_VALUE);
	}
}
