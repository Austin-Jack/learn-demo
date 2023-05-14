package cn.llynsyw.design.pattern.exp.simpleFactory;

/*UnsupportedShapeException�쳣��*/
public class UnsupportedShapeException extends Exception{
    @Override
    public String getMessage() {
        return "UnsupportedShapeException";
    }
}
