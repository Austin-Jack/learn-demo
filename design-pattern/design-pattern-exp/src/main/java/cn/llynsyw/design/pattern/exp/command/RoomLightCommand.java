package cn.llynsyw.design.pattern.exp.command;

/**
 * @Description ���Ƶ�������
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class RoomLightCommand extends AbstractCommand {
	RoomLight light;

	public RoomLightCommand(RoomLight light) {
		this.light = light;
	}

	@Override
	void execute() {
		if (light.getState()) {
			light.turnOff();
		} else {
			light.turnOn();
		}
	}
}
