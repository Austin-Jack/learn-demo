package cn.llynsyw.design.pattern.exp.decorator;

/**
 * @Description 具体报表类
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class ConcreteReport implements Report {
	int row;
	int column;


	@Override
	public void generateReport() {
		System.out.println("生成" + row + "行" + column + "列的报表");
	}

	@Override
	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public void setColum(int colum) {
		this.column = colum;
	}

	@Override
	public int getRow() {
		return this.row;
	}

	@Override
	public int getColum() {
		return this.column;
	}

}
