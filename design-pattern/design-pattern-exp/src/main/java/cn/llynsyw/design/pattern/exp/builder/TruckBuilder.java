package cn.llynsyw.design.pattern.exp.builder;

/*����������*/
public class TruckBuilder extends CarBuilder{
    @Override
    public void buildBody() {
        car.setBody("Truck body");
    }

    @Override
    public void buildEngine() {
        car.setEngine("Truck engine");
    }

    @Override
    public void buildTire() {
        car.setTire("Truck tire");
    }

    @Override
    public void buildGearbox() {
        car.setGearbox("Truck Gearbox");
    }
}
