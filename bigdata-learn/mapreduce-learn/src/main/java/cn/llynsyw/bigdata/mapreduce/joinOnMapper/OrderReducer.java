package cn.llynsyw.bigdata.mapreduce.joinOnMapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/21
 **/
@Deprecated
public class OrderReducer extends Reducer<OrderBean, NullWritable, OrderBean, NullWritable> {
	@Override
	protected void reduce(OrderBean key, Iterable<NullWritable> values, Reducer<OrderBean, NullWritable, OrderBean,
			NullWritable>.Context context) throws IOException, InterruptedException {
		context.write(key, NullWritable.get());
	}
}
