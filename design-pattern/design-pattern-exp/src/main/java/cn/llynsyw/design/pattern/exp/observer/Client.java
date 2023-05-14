package cn.llynsyw.design.pattern.exp.observer;

import cn.llynsyw.design.pattern.exp.observer.editor.EditorArea;
import cn.llynsyw.design.pattern.exp.observer.editor.MyEditorArea;
import cn.llynsyw.design.pattern.exp.observer.panel.FrequencyStatisticalPanel;
import cn.llynsyw.design.pattern.exp.observer.panel.NumbersStaticalPanel;
import cn.llynsyw.design.pattern.exp.observer.panel.StatisticalPanel;
import cn.llynsyw.design.pattern.exp.observer.panel.WordsStaticalPanel;

/**
 * @Author luolinyuan
 * @Date 2022/4/9
 **/
public class Client {
	public static void main(String[] args) {
		EditorArea editor = new MyEditorArea();
		StatisticalPanel[] panels = new StatisticalPanel[]{
				new NumbersStaticalPanel(),
				new WordsStaticalPanel(),
				new FrequencyStatisticalPanel()};
		editor.attach(panels);
		editor.write("this is a sentence for test.������һ�����ڲ��Եľ���) v1312 ��%& 123.8329,3.1415926,0.28");
		editor.write("������һ�в������");
		editor.delete("this");
		editor.clear();
	}
}
