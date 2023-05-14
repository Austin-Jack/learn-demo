package cn.llynsyw.junit.junit2.test;

import cn.llynsyw.junit.junit2.Largest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/8
 **/
public class TestLargest {
	Largest larger = new Largest();

	@Test(expected = Exception.class)
	public void testLargest1() throws Exception {
		int[] array = null;
		larger.getLargest(array);
		fail("array is null");
	}

	@Test(expected = Exception.class)
	public void testLargest2() throws Exception {
		int[] array = new int[0];
		larger.getLargest(array);
		fail("array's length is 0");
	}

	@Test
	public void testLargest3() {
		int[] array = new int[]{-2, 12, 34, 56, 666};
		int largest = 0;
		try {
			largest = larger.getLargest(array);
		} catch (Exception e) {
			fail("mistake");
		}
		assertEquals(666, largest);
	}

}
