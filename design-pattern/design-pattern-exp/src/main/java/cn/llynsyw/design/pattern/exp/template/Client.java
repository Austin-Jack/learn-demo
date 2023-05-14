package cn.llynsyw.design.pattern.exp.template;

import cn.llynsyw.design.pattern.exp.template.classifier.DataClassification;
import cn.llynsyw.design.pattern.exp.utils.XMLUtil;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class Client {
	public static void main(String[] args) {
		DataClassification classifier = (DataClassification) XMLUtil.getBean("templateMethod.xml");
		classifier.process();
	}
}
