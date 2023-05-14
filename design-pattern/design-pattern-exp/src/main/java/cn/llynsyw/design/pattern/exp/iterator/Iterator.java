package cn.llynsyw.design.pattern.exp.iterator;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public interface Iterator<E> {
	boolean hasNext();

	E next();

	void first();

	E[] limit(int count);

	E[][] limitAll(int count);
}
