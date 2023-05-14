package cn.llynsyw.bigdata.mapreduce.partition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/19
 **/
public class PhoneFLowWithPartitionDriver {
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(PhoneFLowWithPartitionDriver.class);

		job.setMapperClass(PhoneFlowMap.class);
		job.setReducerClass(PhoneFlowReduce.class);

		job.setMapOutputValueClass(FlowBean.class);
		job.setMapOutputKeyClass(Text.class);

		job.setPartitionerClass(ProvincePartition.class);
		job.setNumReduceTasks(5);

		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		boolean result = job.waitForCompletion(true);
		System.exit(result ? 0 : 1);
	}
}
