package com.turing.springboot.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-09-05
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("update_time_line")
public class UpdateTimeLine {

    private static final long serialVersionUID = 2955806429097700570L;
    /**
     * 指定主键名、主键生产策略
     */
    @TableId(value = "u_id", type = IdType.AUTO)
    private Integer id;

    @TableField("author")
    private String author;

    @TableField("action")
    private String action;

    @TableField("context")
    private String context;

    @TableField("create_time")
    private Date createTime;

    @TableField("create_by")
    private String createBy;

}
