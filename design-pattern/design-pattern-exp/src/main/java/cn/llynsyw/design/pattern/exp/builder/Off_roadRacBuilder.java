package cn.llynsyw.design.pattern.exp.builder;

/*ԽҰ��������*/
public class Off_roadRacBuilder extends CarBuilder{
    @Override
    public void buildBody() {
        car.setBody("Off_roadRac body");
    }

    @Override
    public void buildEngine() {
        car.setEngine("Off_roadRac engine");
    }

    @Override
    public void buildTire() {
        car.setTire("Off_roadRac tire");
    }

    @Override
    public void buildGearbox() {
        car.setGearbox("Off_roadRac Gearbox");
    }
}
