package org.springcloud.turing.framework.starter.common.utils;

import lombok.extern.slf4j.Slf4j;
import java.util.Random;

/**
 * @descri: 数据生成工具类
 *
 * @author: lj.michale
 * @date: 2023/12/15 14:14
 */
@Slf4j
public class DataGenerateUtils {

    /**
     * @descri: 数组中随机抽取几个不重复的元素
     *
     * @param arrays
     * @param numToSelect
     */
    public static String[] selectRandomArrays(String[] arrays,
                                              int numToSelect) {
        Random random = new Random();
        int[] indexes = random.ints(0, arrays.length).distinct().limit(numToSelect).toArray();
        String[] selectedArrays = new String[numToSelect];

        for (int i = 0; i < numToSelect; i++) {
            selectedArrays[i] = arrays[indexes[i]];
        }

        return selectedArrays;
    }
}
