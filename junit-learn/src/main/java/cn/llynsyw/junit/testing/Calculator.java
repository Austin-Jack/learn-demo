package cn.llynsyw.junit.testing;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/15
 **/
public class Calculator {
	public int add(int a, int b) {
		return a + b;
	}

	public int substract(int a, int b) {
		return b - a; // 错误，应该是 a-b
	}

	public int multiply(int a, int b) {
		return a * b;
	}


	public int divide(int a, int b) throws Exception {
		if (b == 0) {
			throw new Exception("除数不能为 0！");
		}
		return a / b;
	}
}