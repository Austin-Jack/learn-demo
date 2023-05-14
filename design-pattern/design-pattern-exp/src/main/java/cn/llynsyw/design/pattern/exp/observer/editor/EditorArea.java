package cn.llynsyw.design.pattern.exp.observer.editor;

import cn.llynsyw.design.pattern.exp.observer.panel.StatisticalPanel;

/**
 * @Description �ı��༭���ӿ�
 * @Author luolinyuan
 * @Date 2022/4/8
 **/
public abstract class EditorArea {
	protected StatisticalPanel[] panels;

	public abstract void attach(StatisticalPanel[] panels);

	protected abstract void update();

	public abstract void write(String content);

	public abstract void delete(int num);

	public abstract void delete(String str);

	public abstract void clear();
}
