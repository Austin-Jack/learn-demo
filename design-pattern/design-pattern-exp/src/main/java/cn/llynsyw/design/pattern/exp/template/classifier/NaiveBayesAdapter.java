package cn.llynsyw.design.pattern.exp.template.classifier;

import cn.llynsyw.design.pattern.exp.template.classificationAlgorithm.NaiveBayes;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class NaiveBayesAdapter extends DataClassification {
	NaiveBayes bayes = new NaiveBayes();

	@Override
	protected void classify() {
		bayes.NaiveBayesClassify(super.dataBuffer.toString());
	}
}
