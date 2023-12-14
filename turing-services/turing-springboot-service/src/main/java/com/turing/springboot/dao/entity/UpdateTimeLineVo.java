package com.turing.springboot.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-09-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTimeLineVo {

    private static final long serialVersionUID = 2955806429097700570L;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("author")
    private String author;

    @JsonProperty("action")
    private String action;

    @JsonProperty("context")
    private String context;

    @JsonProperty("createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    @JsonProperty("createBy")
    private String createBy;
}
