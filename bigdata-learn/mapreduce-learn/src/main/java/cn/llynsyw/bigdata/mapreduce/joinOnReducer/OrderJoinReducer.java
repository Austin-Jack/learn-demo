package cn.llynsyw.bigdata.mapreduce.joinOnReducer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * TODO
 *
 * @author luolinyuan
 * @date 2023/1/21
 **/
public class OrderJoinReducer extends Reducer<Text, OrderBean, OrderBean, NullWritable> {
	ArrayList<OrderBean> orderBeans = new ArrayList<>();
	String productName;


	@Override
	protected void reduce(Text key, Iterable<OrderBean> values,
	                      Reducer<Text, OrderBean, OrderBean, NullWritable>.Context context) throws IOException,
			InterruptedException {
		orderBeans.clear();

		for (OrderBean value : values) {
			OrderBean tempBean = new OrderBean();
			if ("order".equals(value.getFlag())) {
				try {
					BeanUtils.copyProperties(tempBean, value);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				orderBeans.add(tempBean);
			} else {
				productName = value.getProductName();
			}
		}
		for (OrderBean orderBean : orderBeans) {
			orderBean.setProductName(this.productName);
			context.write(orderBean, NullWritable.get());
		}
	}
}
