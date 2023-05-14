package cn.llynsyw.design.pattern.exp.template.classifier;

import cn.llynsyw.design.pattern.exp.template.classificationAlgorithm.DecisionTree;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class DecisionTreeAdapter extends DataClassification {
	DecisionTree decisionTree = new DecisionTree();

	@Override
	protected void classify() {
		decisionTree.DecisionTreeClassify(super.dataBuffer.toString());
	}
}
