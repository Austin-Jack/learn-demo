package cn.llynsyw.bigdata.mapreduce.combiner;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/18
 **/
public class WordCountMap extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final IntWritable OUT_VALUE = new IntWritable(1);
	private final Text OUT_KEY = new Text();
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		String line = value.toString();

		String[] words = line.split(" ");
		for (String word : words) {
			OUT_KEY.set(word);
			context.write(OUT_KEY, OUT_VALUE);
		}
	}
}
