package cn.llynsyw.design.pattern.exp.builder;
/*ָ����*/
public class Director {
    private CarBuilder carBuilder;

    public void setCarBuilder(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car Construct(){
        carBuilder.buildBody();
        carBuilder.buildTire();
        carBuilder.buildEngine();
        carBuilder.buildGearbox();
        return carBuilder.getCar();
    }
}
