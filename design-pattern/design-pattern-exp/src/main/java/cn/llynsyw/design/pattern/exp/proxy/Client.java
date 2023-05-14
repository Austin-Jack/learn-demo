package cn.llynsyw.design.pattern.exp.proxy;

import cn.llynsyw.design.pattern.exp.utils.XMLUtil;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class Client {
	public static void main(String[] args) {
		StorageSystem<String, String> system;
		system = (StorageSystem<String, String>) XMLUtil.getBean("proxy.xml");
		try{
			system.addData("lly", "2215242978@qq.com");
			system.addData("super", "2283967450@qq.com");
			system.addData("test1","test1@qq.com");
			system.addData("test2","test2@163.com");

			system.addCache("lly", "2215242978@qq.com");
			system.addCache("lc", "2283967450@qq.com");

			System.out.println(system.getData("lly"));
			System.out.println(system.getData("test1"));
			System.out.println(system.getData("test1"));
		}catch (NullPointerException e){
			e.printStackTrace();
		}

	}
}
