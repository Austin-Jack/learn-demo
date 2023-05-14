package cn.llynsyw.design.pattern.exp.simpleFactory;

import cn.llynsyw.design.pattern.exp.utils.XMLUtil;

/*�ͻ�����*/
public class Client {

    public static void main(String args[]) {
        try {
            Shape shape;
            String shapeName = XMLUtil.getProductName("simpleFactory.xml");
            shape = ShapeFactory.produceShape(shapeName);
            shape.draw();
            shape.erase();
        } catch (UnsupportedShapeException e) {
            System.out.println(e.getMessage());
        }
    }
}
