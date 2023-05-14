package cn.llynsyw.bigdata.mapreduce.outputFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/20
 **/
public class LogOutputFormatDriver {
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);


		job.setJarByClass(LogOutputFormatDriver.class);
		job.setMapperClass(OutputFormatMap.class);
		job.setReducerClass(OutputFormatReduce.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);

		job.setOutputValueClass(Text.class);
		job.setOutputValueClass(NullWritable.class);

		job.setPartitionerClass(LogPartition.class);
		job.setNumReduceTasks(2);

		job.setOutputFormatClass(LogOutputFormat.class);

		FileInputFormat.setInputPaths(job, new Path("input"));
		FileOutputFormat.setOutputPath(job, new Path("out"));

		boolean result = job.waitForCompletion(true);
		System.exit(result ? 1 : 0);
	}
}
