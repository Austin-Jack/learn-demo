package cn.llynsyw.junit.testing.test;

import cn.llynsyw.junit.testing.Count;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * @Description Count测试类
 * @Author luolinyuan
 * @Date 2022/4/15
 **/
@RunWith(Parameterized.class)
public class TestCount {
	private int num1;
	private int num2;
	private int num3;
	private int result;
	private Count count;

	@Before
	public void init() {
		count = new Count();
	}

	public TestCount(int num1, int num2, int num3, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.result = result;
	}

	@Parameterized.Parameters
	public static List data() {
		Object[][] nums = {{0, 0, 0, 0}, {10, 10, 10, 0}, {-10, 10, 10, 0}, {-10, -10, 10, 200}, {-10, -10, -10, 0}};
		return Arrays.asList(nums);
	}

	@Test
	public void testCompute() {
		assertEquals(result, count.compute(num1, num2, num3));
	}
}