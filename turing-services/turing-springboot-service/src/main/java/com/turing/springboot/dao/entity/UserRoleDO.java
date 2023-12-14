package com.turing.springboot.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @descri 用户角色
 *
 * @author lj.michale
 * @date 2023-10-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDO {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 角色id
     */
    private String roleId;

}