package cn.llynsyw.design.pattern.exp.iterator;


/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class Client {
	public static void main(String[] args) {
		System.out.println("---------�����ַ�������-----------");
		String[] strings = {"lly", "test1", "test2", "test3"};
		AbstractCollection<String> stringElement = new ConcreteCollection<>(strings);
		Iterator<String> iterator1 = stringElement.createIterator();
		/*��������Ԫ��*/
		while (iterator1.hasNext()) {
			System.out.printf(iterator1.next() + " ");
		}
		/*�Ƶ��ʼ*/
		iterator1.first();
		/*ȡ������Ԫ�� �� ����ڶ���*/
		System.out.println("\n" + iterator1.limit(2)[1]);
		/*��ʣ�µİ�3��һҳ���з�ҳ*/
		String[][] limit1 = iterator1.limitAll(3);

		System.out.println("---------������������------------");
		Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		AbstractCollection<Integer> element = new ConcreteCollection<>(integers);
		Iterator<Integer> iterator2 = element.createIterator();
		Integer[][] tmp = iterator2.limitAll(2);
	}
}
