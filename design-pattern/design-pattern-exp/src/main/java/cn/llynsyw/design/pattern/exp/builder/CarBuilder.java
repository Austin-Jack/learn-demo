package cn.llynsyw.design.pattern.exp.builder;

/*????builder??*/
public abstract class CarBuilder {
    protected Car car = new Car();

    public abstract void buildBody();

    public abstract void buildEngine();

    public abstract void buildTire();

    public abstract void buildGearbox();

    public Car getCar() {
        return car;
    }
}

