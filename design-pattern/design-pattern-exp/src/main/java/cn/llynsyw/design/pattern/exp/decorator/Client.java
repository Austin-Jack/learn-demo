package cn.llynsyw.design.pattern.exp.decorator;

import cn.llynsyw.design.pattern.exp.decorator.reportDecorator.ReportDecorator;
import cn.llynsyw.design.pattern.exp.decorator.reportDecorator.ReportDecoratorA;
import cn.llynsyw.design.pattern.exp.decorator.reportDecorator.ReportDecoratorB;

/**
 * @Description 客户端类
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class Client {
	public static void main(String[] args) {
		Report report = new ConcreteReport();
		report.setColum(20);
		report.setRow(10);
		report.generateReport();

		System.out.println("---------------------");

		ReportDecorator decoratorA = new ReportDecoratorA(report, "花边", "阴影");
		decoratorA.generateReport();

		System.out.println("---------------------");
		ReportDecorator decoratorB = new ReportDecoratorB(report,"条纹","无边框");
		decoratorB.generateReport();
	}

}
