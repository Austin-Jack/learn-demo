package cn.llynsyw.design.pattern.exp.simpleFactory;

/*������*/
public class ShapeFactory {

    public static Shape produceShape(String shapeName) throws UnsupportedShapeException {
        if (shapeName.equals("Circle")) {
            return new Circle();
        } else if (shapeName.equals("Triangle")) {
            return new Triangle();
        } else if (shapeName.equals("Rectangle")) {
            return new Rectangle();
        } else {
            throw new UnsupportedShapeException();
        }
    }
}
