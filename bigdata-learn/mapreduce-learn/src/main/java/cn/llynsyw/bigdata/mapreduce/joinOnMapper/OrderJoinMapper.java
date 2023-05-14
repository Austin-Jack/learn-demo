package cn.llynsyw.bigdata.mapreduce.joinOnMapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/21
 **/
public class OrderJoinMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {
	private final HashMap<String, String> PD_MAP = new HashMap<>();
	private final OrderBean OUT_KEY = new OrderBean();

	@Override
	protected void setup(Mapper<LongWritable, Text, OrderBean, NullWritable>.Context context) throws IOException,
			InterruptedException {
		FSDataInputStream fis = FileSystem.get(context.getConfiguration()).open(
				new Path(context.getCacheFiles()[0]));
		//通过包装流转换为 reader,方便按行读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8));
		String line;
		while (StringUtils.isNotEmpty(line = reader.readLine())) {
			String[] split = line.split("\t");
			this.PD_MAP.put(split[0], split[1]);
		}

		IOUtils.closeStream(reader);
	}

	@Override
	protected void map(LongWritable key, Text value,
	                   Mapper<LongWritable, Text, OrderBean, NullWritable>.Context context) throws IOException,
			InterruptedException {
		String[] split = value.toString().split("\t");

		OUT_KEY.setOrderId(split[0]);
		OUT_KEY.setProductName(this.PD_MAP.get(split[1]));
		OUT_KEY.setAmount(Integer.valueOf(split[2]));
		context.write(OUT_KEY, NullWritable.get());
	}
}
