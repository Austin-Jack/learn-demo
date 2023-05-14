package cn.llynsyw.junit.junit.test;

import cn.llynsyw.junit.junit2.test.TestLargest;
import cn.llynsyw.junit.junit2.test.TestTax;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
@RunWith(Suite.class)
@Suite.SuiteClasses({TestDivide.class, TestMyStack.class, TestLargest.class, TestTax.class})
public class TestAll {
}
