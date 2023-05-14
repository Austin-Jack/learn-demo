package cn.llynsyw.design.pattern.exp.singleton;


import cn.llynsyw.design.pattern.exp.singleton.doubleCheck.VirtualUserGenerator;

public class Client {
	public static void main(String[] args) {
		VirtualUserGenerator virtual1 =
				VirtualUserGenerator.getInstance();
		VirtualUserGenerator virtual2 =
				VirtualUserGenerator.getInstance();
		System.out.println("virtual1 == virtual2? :" + (virtual1 == virtual2));
		cn.llynsyw.design.pattern.exp.singleton.IoDH.VirtualUserGenerator virtual3 =
				cn.llynsyw.design.pattern.exp.singleton.IoDH.VirtualUserGenerator.getInstance();
		cn.llynsyw.design.pattern.exp.singleton.IoDH.VirtualUserGenerator virtual4 =
				cn.llynsyw.design.pattern.exp.singleton.IoDH.VirtualUserGenerator.getInstance();
		System.out.println("virtual3 == virtual4? :" + (virtual3 == virtual4));
	}

}
