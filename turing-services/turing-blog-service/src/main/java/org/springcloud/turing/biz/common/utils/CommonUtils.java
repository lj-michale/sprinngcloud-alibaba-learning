package org.springcloud.turing.biz.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-10-23
 */
public class CommonUtils {

    /**
     * 检测邮箱是否合法
     *
     * @param username 用户名
     * @return 合法状态
     */
    public static boolean checkEmail(String username) {
        String rule = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(rule);
        Matcher m = p.matcher(username);

        return m.matches();
    }
}
