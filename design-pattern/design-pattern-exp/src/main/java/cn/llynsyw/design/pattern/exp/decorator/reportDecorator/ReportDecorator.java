package cn.llynsyw.design.pattern.exp.decorator.reportDecorator;

import cn.llynsyw.design.pattern.exp.decorator.Report;

/**
 * @Description 报表抽象装饰类
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public abstract class ReportDecorator implements Report {
	protected Report report;
	protected String header;
	protected String footer;

	@Override
	public void setRow(int row) {
		report.setRow(row);
	}

	@Override
	public void setColum(int colum) {
		report.setColum(colum);
	}

	public int getColum() {
		return report.getColum();
	}

	public int getRow() {
		return report.getRow();
	}

	public abstract void addHeader();

	public abstract void addFooter();
}
