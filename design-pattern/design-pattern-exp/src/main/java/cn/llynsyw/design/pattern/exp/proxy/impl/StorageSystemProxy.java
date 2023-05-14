package cn.llynsyw.design.pattern.exp.proxy.impl;

import cn.llynsyw.design.pattern.exp.proxy.StorageSystem;

import java.util.HashMap;

/**
 * @Description 系统代理类
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class StorageSystemProxy<K, V> implements StorageSystem<K, V> {
	HashMap<K, V> cache;
	RealStorageSystem<K, V> storageSystem;

	public StorageSystemProxy() {
		cache = new HashMap<>();
		storageSystem = new RealStorageSystem<>();
	}

	@Override
	public V getData(K key) {
		if (cache.containsKey(key)) {
			System.out.println("从缓存中获取数据....");
			return cache.get(key);
		}
		V value = storageSystem.getData(key);
		if (value != null) {
			cache.put(key, value);
			System.out.println("将未命中输入加入缓存中....");
		}
		return value;
	}

	@Override
	public void addCache(K key, V value) {
		if (storageSystem.isExist(key)) {
			cache.put(key, value);
		} else {
			System.out.println("系统中不存在该数据，无法加入缓存...");
		}
	}

	@Override
	public void addData(K key, V value) {
		this.storageSystem.addData(key, value);
	}
}
