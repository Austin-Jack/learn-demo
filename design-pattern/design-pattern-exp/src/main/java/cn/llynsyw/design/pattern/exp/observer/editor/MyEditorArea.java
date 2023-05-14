package cn.llynsyw.design.pattern.exp.observer.editor;

import cn.llynsyw.design.pattern.exp.observer.panel.StatisticalPanel;


/**
 * @Description TODO
 * @Author luolinyuan
 * @Date 2022/4/8
 **/
public class MyEditorArea extends EditorArea {
	private StringBuilder content;

	public MyEditorArea() {
		this.content = new StringBuilder();
	}

	@Override
	public void attach(StatisticalPanel[] panels) {
		this.panels = panels;
	}

	@Override
	protected void update() {
		System.out.println("------------------------------------------------------------");
		for (StatisticalPanel panel : panels) {
			panel.update(this.content.toString().trim());
		}
	}

	@Override
	public void write(String content) {
		this.content.append(" ").append(content);
		update();
	}

	@Override
	public void delete(int num) {
		int endIndex = this.content.length();
		endIndex = Math.max(endIndex, num);
		this.content.delete(endIndex - num, endIndex);
		update();
	}

	@Override
	public void delete(String str) {
		int index = this.content.indexOf(str, 0);
		this.content.delete(index, index + str.length());
		update();
	}

	@Override
	public void clear() {
		this.content.setLength(0);
		update();
	}

}
