package cn.llynsyw.design.pattern.exp.observer.panel;

import java.text.Collator;
import java.util.Locale;
import java.util.TreeSet;

/**
 * @Description Client��
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class WordsStaticalPanel implements StatisticalPanel {
	@Override
	public void update(String content) {
		/*�����ֵ�������*/
		TreeSet<String> set = new TreeSet<>(Collator.getInstance(Locale.CHINESE));
		if (content.length() != 0) {
			/*����Ӣ�ĵ��ʡ����ġ�����*/
			content = content.replaceAll("[\\pP\\p{Punct}&&[^.]]", " ");
			for (String s : content.split("\\s+")) {
				char c = s.charAt(0);
				if (Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN) {
					for (char ch : s.toCharArray()) {
						set.add(String.valueOf(ch));
					}
				} else {
					if (s.endsWith(".")) {
						set.add(s.substring(0, s.length() - 1));
					} else {
						set.add(s);
					}
				}
			}
		}
		System.out.println("���ֵĵ�����:\n"+set);
	}
}
