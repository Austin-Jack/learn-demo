package cn.llynsyw.design.pattern.exp.proxy.impl;

import cn.llynsyw.design.pattern.exp.proxy.StorageSystem;

import java.util.HashMap;

/**
 * @Description 真实存储类
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
class RealStorageSystem<K,V> implements StorageSystem<K,V> {
	private HashMap<K,V> data;

	public RealStorageSystem(){
		data = new HashMap<>();
	}

	@Override
	public V getData(K key) {
		if(data.containsKey(key)) {
			System.out.println("从系统中获取数据...");
			return data.get(key);
		}
		System.out.println("系统中不存在该数据：" + key);
		return null;
	}

	@Override
	public void addData(K key, V value) {
		data.put(key,value);
	}

	public boolean isExist(K key) {
		return data.containsKey(key);
	}
}
