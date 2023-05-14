package cn.llynsyw.spring.mvc.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*自定义转换器 需要在springmvc.xml中配置*/
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        //    将日期字符串转为日期对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
