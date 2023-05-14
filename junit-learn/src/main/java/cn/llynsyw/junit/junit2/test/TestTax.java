package cn.llynsyw.junit.junit2.test;

import cn.llynsyw.junit.junit2.Tax;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @Description 测试Tax类
 * @Author luolinyuan
 * @Date 2022/4/8
 **/
@RunWith(Parameterized.class)
public class TestTax {
	private final float salary;
	private Tax tax;
	private float expectedTax;

	@Before
	public void init() {
		tax = new Tax();
	}

	@Parameterized.Parameters
	public static List<Object[]> data() {
		Object[][] object = {{0f, 0f}, {2000f, 0f}, {2200f, 10.0f},
				{2500f, 25.0f}, {2600.0f, 26.0f}, {4000.0f, 175.0f},
				{4200.0f, 205.0f}, {7000.0f, 625.0f}, {7300.0f, 685.0f},
				{22000.0f, 3625.0f}, {24000.0f, 4125.0f}, {42000.0f, 8625.0f},
				{45000.0f, 9525.0f}, {62000.0f, 14625.0f}, {68000.0f, 16725.0f},
				{82000.0f, 21625.0f}, {88000.0f, 24025.0f}, {120000.0f, 37725.0f},
				{150000.0f, 51225.0f}
		};
		return Arrays.asList(object);
	}


	public TestTax(float salary, float expectedTax) {
		this.salary = salary;
		this.expectedTax = expectedTax;
	}

	@Test
	public void testTax() {
		assertEquals(this.expectedTax, tax.countTax(this.salary), 0.0);
	}
}
