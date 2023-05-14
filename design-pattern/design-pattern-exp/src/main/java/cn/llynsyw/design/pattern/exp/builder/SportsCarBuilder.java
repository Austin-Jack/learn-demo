package cn.llynsyw.design.pattern.exp.builder;

/*�˶�����������*/
public class SportsCarBuilder extends CarBuilder{
    @Override
    public void buildBody() {
        car.setBody("SportsCar body");
    }

    @Override
    public void buildEngine() {
        car.setEngine("SportsCar engine");
    }

    @Override
    public void buildTire() {
        car.setTire("SportsCar tire");
    }

    @Override
    public void buildGearbox() {
        car.setGearbox("SportsCar Gearbox");
    }
}
