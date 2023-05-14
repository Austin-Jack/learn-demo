package cn.llynsyw.junit.date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class DiaryDetection extends Application {

    /*年月日*/
    private int year;
    private int month;
    private int day;

    /*绑定窗体控件*/
    @FXML
    private TextField dayInput;

    @FXML
    public Text outputText;

    @FXML
    private Button flushButton;

    @FXML
    private TextField monthInput;

    @FXML
    private Button outButton;

    @FXML
    private TextField yearInput;

    @FXML
    void onFlushButton(ActionEvent event) {
        yearInput.clear();
        monthInput.clear();
        dayInput.clear();
        outputText.setText("");
    }


    @FXML
    void onOutButton(ActionEvent event) {
        /*创建消息提示框备用*/
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.titleProperty().set("错误");
        /*获取输入的内容*/
        String yearInputText = yearInput.getText();
        String monthInputText = monthInput.getText();
        String dayInputText = dayInput.getText();
        /*错误码*/
        int errorCode = 0;
        /*解析成数字可能会抛出异常*/
        try {
            year = Integer.parseInt(yearInputText);
            errorCode = 1;
            month = Integer.parseInt(monthInputText);
            errorCode = 2;
            day = Integer.parseInt(dayInputText);
            String result = null;
            if (year < 1000 || year > 9999) {
                yearInput.clear();
                result = "输入年份超出范围";
            } else if (month < 1 || month > 12) {
                monthInput.clear();
                result = "输入月份超出范围";
            } else if (day < 1 || day > 31) {
                dayInput.clear();
                result = "输入日期超出范围";
            } else if (month == 2 && isLeapYear() && day > 29) {
                dayInput.clear();
                result = year + "年为闰年日期超过29天";
            } else if (month == 2 && !isLeapYear() && day > 28) {
                dayInput.clear();
                result = year + "年不为闰年日期超过28天";
            }
            if (result == null) {
                /*Calendar类中月份从0开始*/
                Calendar calendar =
                        new Calendar.Builder().setDate(year, month - 1, day).build();
                /*往后加一天*/
                calendar.add(Calendar.DATE, 2);
                String outTime = new SimpleDateFormat("yyyy年MM月dd日").format(calendar.getTime());
                outputText.setText(outTime);
            } else {
                alert.headerTextProperty().set(result);
                alert.showAndWait();
                outputText.setText("");
            }
        } catch (Exception e) {
            /*抛出异常表示是输入的文本包含非数字
            根据错误码可以确定是哪一个文本框输入错误*/
            switch (errorCode) {
                case 0:
                    if (yearInputText.isEmpty()) {
                        alert.headerTextProperty().set("输入年份为空");
                    } else {
                        alert.headerTextProperty().set("输入年份不合法");
                    }
                    yearInput.clear();
                    break;
                case 1:
                    if (monthInputText.isEmpty()) {
                        alert.headerTextProperty().set("输入月份为空");
                    } else {
                        alert.headerTextProperty().set("输入月份不合法");
                    }
                    monthInput.clear();
                    break;
                case 2:
                    if (dayInputText.isEmpty()) {
                        alert.headerTextProperty().set("输入日期为空");
                    } else {
                        alert.headerTextProperty().set("输入日期不合法");
                    }
                    dayInput.clear();
                    break;
            }
            alert.showAndWait();
            outputText.setText("");
        }
    }

    /*判断是否是闰年*/
    public boolean isLeapYear() {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }


    /*窗口启动类*/
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*窗体标题*/
        primaryStage.setTitle("隔一天");
        /*窗体图标*/
        primaryStage.getIcons().add(new Image("main/java/junit/date/date.png"));
        primaryStage.setResizable(false);
        /*窗体布局文件*/
        Parent root = FXMLLoader.load(getClass().getResource("DiaryDetection.fxml"));
        /*使布局生效*/
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        /*启动窗口*/
        Application.launch(args);
    }
}

