package cn.llynsyw.junit.testing.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Description 套件测试类
 * @Author luolinyuan
 * @Date 2022/4/15
 **/
@RunWith(Suite.class)
@Suite.SuiteClasses({TestCalculator.class, TestCount.class})
public class TestAll {
}
