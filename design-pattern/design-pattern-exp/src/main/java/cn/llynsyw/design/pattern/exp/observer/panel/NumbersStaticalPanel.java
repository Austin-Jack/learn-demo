package cn.llynsyw.design.pattern.exp.observer.panel;

/**
 * @Description ������Ŀͳ��
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class NumbersStaticalPanel implements StatisticalPanel {
	static final String SPECIAL_CHARACTERS = " sp ";

	@Override
	public void update(String content) {
		int number = 0;
		if (content.length() != 0) {
			/*����С��������������滻*/
			content = content.replaceAll("[\\pP\\p{Punct}&&[^.]]", SPECIAL_CHARACTERS);
			/*�Կո񻮷�*/
			String[] strings = content.split("\\s+");
			for (String s : strings) {
				if (Character.UnicodeScript.of(s.charAt(0)) == Character.UnicodeScript.HAN) {
					number += s.length();
				} else {
					number++;
				}
			}
		}
		System.out.println("����+�ַ�����Ϊ: " + number);
	}
}
