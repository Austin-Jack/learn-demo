package cn.llynsyw.junit.test;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class MyStackTest {
	MyStack myStack;

	@Before
	public void init() {
		myStack = new MyStack();
	}

	@Test
	public void testPush1() {
		/*测试空栈下压入元素*/
		try {
			myStack.push("lly");
			assertEquals(1, myStack.nextIndex);
			assertEquals("lly", myStack.top());
		} catch (Exception e) {
			fail("push fail by testPush1");
		}
	}

	@Test
	public void testPush2() {
		/*测试压入随机个数元素(在合法范围内 m最大为99)*/
		int m = new Random().nextInt(100);
		try {
			for (int i = 0; i < m; i++) {
				myStack.push("lly" + i);
				assertEquals(i + 1, myStack.nextIndex);
				assertEquals("lly" + i, myStack.top());
			}
		} catch (Exception e) {
			fail("push fail by testPush2");
		}
	}

	@Test
	public void testPush3() {
		/*测试放入100个元素 即满栈*/
		try {
			for (int i = 0; i < 100; i++) {
				myStack.push("lly" + i);
			}
			assertEquals(100, myStack.nextIndex);
			assertEquals("lly" + 99, myStack.top());
		} catch (Exception e) {
			fail("push fail by testPush3");
		}
	}

	@Test(expected = Exception.class)
	public void testPush4() throws Exception {
		for (int i = 0; i < 100; i++) {
			myStack.push("lly" + i);
		}
		myStack.push("the last");
		fail("push fail by testPush4");
	}

	@Test(expected = Exception.class)
	public void testPop1() throws Exception {
		/*测试空栈情况下pop*/
		myStack.pop();
		fail("pop fail by testPop1");
	}

	@Test
	public void testPop2() {
		/*测试一个元素下的pop*/
		try {
			myStack.push("lly");
			assertEquals("lly", myStack.pop());
			assertEquals(0, myStack.nextIndex);
		} catch (Exception e) {
			fail("pop fail by testPop2");
		}
	}

	@Test
	public void testPop3() {
		/*测试随机个数下的pop*/
		int m = new Random().nextInt(100);
		try {
			for (int i = 0; i < m; i++) {
				myStack.push("lly" + i);
			}
			assertEquals("lly" + (m - 1), myStack.pop());
			assertEquals(m - 1, myStack.nextIndex);
		} catch (Exception e) {
			fail("pop fail by testPop3");
		}
	}

	@Test
	public void testPop4() {
		/*测试栈满的情况下的pop*/
		try {
			for (int i = 0; i < 100; i++) {
				myStack.push("lly" + i);
			}
			assertEquals("lly" + 99, myStack.pop());
			assertEquals(99, myStack.nextIndex);
		} catch (Exception e) {
			fail("pop fail by testPop4");
		}
	}

	@Test(expected = Exception.class)
	public void testTop1() throws Exception {
		/*测试空栈下的pop*/
		myStack.pop();
		fail("top fail by testPop1");
	}

	@Test
	public void testTop2() {
		/*测试一个元素情况下的top*/
		try {
			myStack.push("lly");
			assertEquals("lly", myStack.top());
		} catch (Exception e) {
			fail("top fail by testTop2");
		}
	}

	@Test
	public void testTop3() {
		/*测试随机个数下的top*/
		int m = new Random().nextInt(100);
		try {
			for (int i = 0; i < m; i++) {
				myStack.push("lly" + i);
			}
			assertEquals("lly" + (m - 1), myStack.top());
		} catch (Exception e) {
			fail("top fail by testTop3");

		}
	}

	@Test
	public void testTop4() {
		/*测试满栈的情况下的top*/
		try {
			for (int i = 0; i < 100; i++) {
				myStack.push("lly" + i);
			}
			assertEquals("lly" + 99, myStack.top());
		} catch (Exception e) {
			fail("top fail by testTop4");
		}
	}

	@Test(expected = Exception.class)
	public void testDelete1() throws Exception {
		/*测试空栈下的delete*/
		myStack.delete(2);
		fail("delete fail by testDelete1");
	}

	@Test
	public void testDelete2() {
		/*测试只有一个元素下的delete*/
		try {
			myStack.push("lly");
			myStack.delete(1);
			assertEquals(0, myStack.nextIndex);
		} catch (Exception e) {
			fail("delete fail by testDelete2");
		}
	}

	@Test
	public void testDelete3() {
		/*测试随机个数下的delete*/
		int m = new Random().nextInt(100);
		int n = new Random().nextInt(m);
		try {
			for (int i = 0; i < m; i++) {
				myStack.push("lly" + i);
			}
			myStack.delete(n);
			assertEquals(m - n, myStack.nextIndex);
			assertEquals("lly" + (m - n - 1), myStack.top());
		} catch (Exception e) {
			fail("delete fail by testDelete3");
		}
	}
}
