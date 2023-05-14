package cn.llynsyw.junit.junit.test;

import cn.llynsyw.junit.junit.Divide;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class TestDivide {
	private static Divide div;

	@Before
	public void init() {
		div = new Divide();
		div.setResult(10);
	}

	@Test
	public void testDive(){
		div.divide(10);
		assertEquals(1,div.getResult());
	}

	@Test(expected = Exception.class)
	public void divideZero(){
		div.divide(0);
	}

}
