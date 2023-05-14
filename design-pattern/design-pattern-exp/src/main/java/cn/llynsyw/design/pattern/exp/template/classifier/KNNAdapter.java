package cn.llynsyw.design.pattern.exp.template.classifier;

import cn.llynsyw.design.pattern.exp.template.classificationAlgorithm.KNN;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class KNNAdapter extends DataClassification{
	KNN knn = new KNN();
	@Override
	protected void classify() {
		knn.KNNClassify(super.dataBuffer.toString());
	}

}
