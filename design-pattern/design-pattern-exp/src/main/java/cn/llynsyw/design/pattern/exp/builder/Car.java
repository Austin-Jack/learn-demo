package cn.llynsyw.design.pattern.exp.builder;

/*������*/
public class Car {
    private String body;
    private String engine;
    private String tire;
    private String gearbox;

    public String getBody() {
        return body;
    }

    public String getEngine() {
        return engine;
    }

    public String getTire() {
        return tire;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }
}
