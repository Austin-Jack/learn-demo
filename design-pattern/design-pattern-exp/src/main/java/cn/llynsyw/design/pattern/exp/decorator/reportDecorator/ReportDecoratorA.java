package cn.llynsyw.design.pattern.exp.decorator.reportDecorator;

import cn.llynsyw.design.pattern.exp.decorator.Report;

/**
 * @Description 具体报表装饰类A
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class ReportDecoratorA extends ReportDecorator {

	public ReportDecoratorA(Report report, String header, String footer) {
		this.report = report;
		this.header = header;
		this.footer = footer;
	}

	@Override
	public void generateReport() {
		/*先添加表尾*/
		addFooter();
		report.generateReport();
		addHeader();
	}

	@Override
	public void addHeader() {
		System.out.println("添加" + this.header + "样式的表头");
	}

	@Override
	public void addFooter() {
		System.out.println("添加" + this.footer + "样式的表尾部");
	}
}
