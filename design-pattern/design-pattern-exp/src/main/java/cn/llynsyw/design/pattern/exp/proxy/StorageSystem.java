package cn.llynsyw.design.pattern.exp.proxy;


/**
 * @Description 存储系统接口
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public interface StorageSystem<K, V> {

	public V getData(K key);

	public default void addCache(K key, V value) {
	}

	public void addData(K key,V value);
}
