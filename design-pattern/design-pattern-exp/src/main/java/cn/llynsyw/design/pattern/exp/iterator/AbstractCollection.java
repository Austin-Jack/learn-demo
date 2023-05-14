package cn.llynsyw.design.pattern.exp.iterator;

/**
 * @Description ����Ԫ����
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public interface AbstractCollection<E> {
	Iterator<E> createIterator();
}
