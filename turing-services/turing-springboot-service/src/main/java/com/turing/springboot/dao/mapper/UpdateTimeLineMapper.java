package com.turing.springboot.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.turing.springboot.dao.entity.UpdateTimeLine;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @descri:
 *
 * @author: lj.michale
 * @date: 2023/12/14 14:13
 */
@Repository
public interface UpdateTimeLineMapper extends BaseMapper<UpdateTimeLine> {

    /**
     * 查询系统更新日志时间线
     *
     * @return list
     */
    List<UpdateTimeLine> getUpdateTimeLines();

}
