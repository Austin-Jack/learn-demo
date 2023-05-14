package cn.llynsyw.bigdata.mapreduce.outputFormat;

import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/20
 **/
public class LogOutputFormat extends FileOutputFormat<Text, NullWritable> {

	@Override
	public RecordWriter<Text, NullWritable> getRecordWriter(TaskAttemptContext taskAttemptContext) throws IOException,
			InterruptedException {
		return new RecordWriter<Text, NullWritable>() {
			private final FSDataOutputStream TARGET_OUTPUT_STREAM;
			private final FileSystem fileSystem = FileSystem.get(taskAttemptContext.getConfiguration());
			private final FSDataOutputStream OTHER_OUTPUT_STREAM;
			private static final String PATH_PREFIX = "hdfs://hadoop101:8020/mapreduce/outputFormat";
			private static final String TARGET_LOG_PATH = PATH_PREFIX + "/atguigu.log";
			private static final String OTHER_LOG_PATH = PATH_PREFIX + "/other.log";

			{
				TARGET_OUTPUT_STREAM = fileSystem.create(new Path(TARGET_LOG_PATH));
				OTHER_OUTPUT_STREAM = fileSystem.create(new Path(OTHER_LOG_PATH));
			}

			@Override
			public void write(Text text, NullWritable nullWritable) throws IOException {
				String str = text.toString();
				if (str.contains("atguigu")) {
					TARGET_OUTPUT_STREAM.writeBytes(str + "\n");
				} else {
					OTHER_OUTPUT_STREAM.writeBytes(str + "\n");
				}
			}

			@Override
			public void close(TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {
				fileSystem.close();
			}
		};
	}
}
