package cn.llynsyw.junit.testing.test;

import cn.llynsyw.junit.testing.Calculator;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @Description Calculator测试类
 * @Author luolinyuan
 * @Date 2022/4/15
 **/
public class TestCalculator {
	private Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
	}

	@Test
	public void testAdd() {
		int a = 1;
		int b = 2;
		assertEquals(3, calculator.add(1, 2));
	}

	@Test
	public void testSubtract() {
		int a = 1;
		int b = 2;
		assertEquals(-1, calculator.substract(a, b));
	}

	@Test
	public void testMultiply() {
		int a = 22;
		int b = 3;
		assertEquals(66, calculator.multiply(a, b));
	}

	@Test(expected = Exception.class)
	public void testDivide() throws Exception {
		int a = 2;
		int b = 0;
		calculator.divide(2, 0);
		fail("didNotDetectDivisorIs0");
	}

	@Test
	public void testDivide2() {
		/*测试随机随机数的除法*/
		Random random = new Random();
		int a = 2;
		int b = 1;
		try {
			assertEquals(2, calculator.divide(a, b));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
