package cn.llynsyw.bigdata.mapreduce.phoneFlow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/19
 **/
public class PhoneFlowReduce extends Reducer<Text, FlowBean, Text, FlowBean> {
	private final Text OUT_KEY = new Text();
	private final FlowBean OUT_VALUE = new FlowBean();
	long totalUpFlow;
	long totalDownFlow;

	@Override
	protected void reduce(Text key, Iterable<FlowBean> values,
	                      Reducer<Text, FlowBean, Text, FlowBean>.Context context) throws IOException,
			InterruptedException {
		totalUpFlow = 0;
		totalDownFlow = 0;
		for (FlowBean flowBean : values) {
			totalDownFlow += flowBean.getDownFlow();
			totalUpFlow += flowBean.getUpFlow();
		}
		OUT_VALUE.setDownFlow(totalDownFlow);
		OUT_VALUE.setUpFlow(totalUpFlow);
		OUT_VALUE.setTotalFlow();
		context.write(key, OUT_VALUE);
	}
}
