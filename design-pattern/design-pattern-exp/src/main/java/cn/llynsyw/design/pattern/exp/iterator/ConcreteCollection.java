package cn.llynsyw.design.pattern.exp.iterator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * @Description ����Ԫ����
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class ConcreteCollection<E> implements AbstractCollection<E> {
	private E[] elements;


	public ConcreteCollection(E[] elements) {
		this.elements = elements;
	}

	@Override
	public Iterator<E> createIterator() {
		return new ConcreteIterator();
	}


	public class ConcreteIterator implements Iterator<E> {
		int currentIndex;
		int size = elements.length;

		@Override
		public boolean hasNext() {
			return currentIndex != elements.length;
		}

		@Override
		public E next() {
			if (currentIndex >= size)
				throw new NoSuchElementException();
			return (E) elements[currentIndex++];
		}

		@Override
		public void first() {
			currentIndex = 0;
		}


		@Override
		public E[] limit(int count) {
			if (elements == null || elements.length == 0) {
				return null;
			}
			int i = 0;
			E[] e;
			ArrayList<E> list = new ArrayList<>();
			while (i++ < count && hasNext()) {
				list.add(next());
			}
			return list.toArray((E[]) Array.newInstance(elements[0].getClass(), 0));
		}

		@Override
		public E[][] limitAll(int count) {
			ArrayList<E[]> pages = new ArrayList<>();
			while (hasNext()) {
				E[] page = limit(count);
				pages.add(page);
			}
			E[][] res = pages.toArray((E[][]) Array.newInstance(elements.getClass(), 0));
			int i = 0, j;
			for (; i < res.length; i++) {
				System.out.printf("page" + (i + 1) + ": {");
				for (j = 0; j < res[i].length - 1; j++) {
					System.out.printf(res[i][j] + ",");
				}
				System.out.println(res[i][j] + "}");
			}
			return res;
		}
	}
}
