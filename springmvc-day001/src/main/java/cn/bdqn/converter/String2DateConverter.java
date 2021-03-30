package cn.bdqn.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *      字符串到日期的转换
 *          S: Source 源
 *          T: target 目标
 */
public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if(source == null || "".equals(source.trim())){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                return sdf.parse(source);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
