package cn.llynsyw.design.pattern.exp.command;

import java.util.ArrayList;

/**
 * @Description �ͻ�����
 * @Author luolinyuan
 * @Date 2022/4/1
 **/
public class Client {
	public static void main(String[] args) {
		ArrayList<AbstractCommand> commandList = new ArrayList<>();
		commandList.add(new RoomLightCommand(new RoomLight("����")));
		commandList.add(new RoomLightCommand(new RoomLight("����")));
		commandList.add(new RoomLightCommand(new RoomLight("����")));
		commandList.add(new RoomLightCommand(new RoomLight("ԡ��")));
		commandList.add(new RoomLightCommand(new RoomLight("����")));


		Controller controller = new Controller(commandList.toArray(AbstractCommand[]::new));


		controller.controlSlotN(0);
		controller.controlSlotN(1);
		controller.controlSlotN(2);
		controller.controlSlotN(3);
		controller.controlSlotN(4);
		controller.controlSlotN(3);
	}
}
