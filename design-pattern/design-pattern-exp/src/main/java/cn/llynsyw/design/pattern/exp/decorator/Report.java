package cn.llynsyw.design.pattern.exp.decorator;

/**
 * @Description 报表接口
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public interface Report {
	void generateReport();
	void setRow(int row);
	void setColum(int colum);
	int getRow();
	int getColum();
}
