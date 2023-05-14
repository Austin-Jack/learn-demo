package cn.llynsyw.java.basic.day06.demo01;

public class Computer {
    public void powerOff() {
        System.out.printf("关闭电脑");
    }

    public void powerOn() {
        System.out.println("打开电脑");
    }

    public void useDevice(USB usb) {
        usb.open();
        if (usb instanceof Mouse) {
            ((Mouse) usb).useMouse();
        } else if (usb instanceof Keyboard) {
            ((Keyboard) usb).useKeyboard();
        }

        usb.close();
    }
}
