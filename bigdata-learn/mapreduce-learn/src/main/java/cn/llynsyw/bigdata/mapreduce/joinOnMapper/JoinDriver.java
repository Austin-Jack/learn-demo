package cn.llynsyw.bigdata.mapreduce.joinOnMapper;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/21
 **/
public class JoinDriver {


	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(JoinDriver.class);
		job.setMapperClass(OrderJoinMapper.class);
		//job.setReducerClass(OrderReducer.class);
		job.setNumReduceTasks(0);
		job.addCacheFile(new URI("hdfs://hadoop101:8020/cache/pd.txt"));

		job.setMapOutputKeyClass(OrderBean.class);
		job.setMapOutputValueClass(NullWritable.class);
		job.setOutputKeyClass(OrderBean.class);
		job.setOutputValueClass(NullWritable.class);
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		boolean b = job.waitForCompletion(true);
		System.exit(b ? 0 : 1);
	}
}
