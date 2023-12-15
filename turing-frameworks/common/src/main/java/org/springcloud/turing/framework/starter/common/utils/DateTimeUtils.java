package org.springcloud.turing.framework.starter.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @descri: 时间日期处理工具
 *
 * @author: lj.michale
 * @date: 2023/12/15 14:13
 */
@Slf4j
public class DateTimeUtils {

    /**
     * 定义日期格式
     * */
    private final static String[] dateFormatArr = {
            "yyyy-MM",
            "yyyy-MM-dd",
            "yyyy-MM-dd HH:mm:ss"
    };


    /**
     * @descri:
     *
     * @param startDate 2021-1-1 00:00:00
     * @param endDate  2021-11-11 00:00:00
     * @param formatType
     */
    public static String getGenerateDate(String startDate,
                                   String endDate,
                                   Integer formatType) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatArr[formatType]);
        long start = sdf.parse(startDate).getTime();
        long end = sdf.parse(endDate).getTime();
        Random random = new Random();
        long bizDate = start + (long) (random.nextDouble() * (end - start + 1));

        return sdf.format(new Date(bizDate));
    }

}
