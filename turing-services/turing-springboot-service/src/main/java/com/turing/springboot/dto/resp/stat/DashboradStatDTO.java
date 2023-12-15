package com.turing.springboot.dto.resp.stat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @descri: 指标概览
 *
 * @author: lj.michale
 * @date: 2023/12/15 11:14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboradStatDTO {

    /**
     * 指标名称
     * */
    private String indexName;

    /**
     * 指标值
     * */
    private double indexValue;

    /**
     * 计算时间
     * */
    private String dateTime;

    /**
     * 同比
     * */
    private double tbRate;

    /**
     * 环比
     * */
    private double hbRate;

}
