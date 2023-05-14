package cn.llynsyw.design.pattern.exp.observer.panel;

import java.text.Collator;
import java.util.Locale;
import java.util.TreeMap;

/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class FrequencyStatisticalPanel implements StatisticalPanel {
	private TreeMap<String, Integer> frequencyMap;

	@Override
	public void update(String content) {
		frequencyMap = new TreeMap<>(Collator.getInstance(Locale.CHINESE));
		if (content.length() != 0) {
			/*����Ӣ�ĵ��ʡ����ġ�����*/
			content = content.replaceAll("[\\pP\\p{Punct}&&[^.]]", " ");
			for (String s : content.split("\\s+")) {
				char c = s.charAt(0);
				if (Character.UnicodeScript.of(c) == Character.UnicodeScript.HAN) {
					/*�����ַ���ɴ򵥸�*/
					for (char ch : s.toCharArray()) {
						put(ch);
					}
				} else {
					put(s);
				}
			}
		}
		print();
	}

	void put(String s) {
		int times = 1;
		if (s.endsWith(".")) {
			s = s.substring(0, s.length() - 1);
		}
		if (frequencyMap.containsKey(s)) {
			times = frequencyMap.get(s);
			times++;
		}
		frequencyMap.put(s, times);
	}

	void put(char ch) {
		put(String.valueOf(ch));
	}

	void print() {
		System.out.println("����Ƶ�ʣ�");
		frequencyMap.forEach((key, value) -> {
			System.out.print(key + ":" + value + "\t");
		});
		System.out.println();
	}

	TreeMap<String, Integer> getFrequencyMap() {
		return this.frequencyMap;
	}
}
