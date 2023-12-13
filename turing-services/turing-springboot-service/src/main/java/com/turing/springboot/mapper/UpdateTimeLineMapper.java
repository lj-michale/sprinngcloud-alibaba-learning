package com.turing.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.turing.springboot.dao.model.UpdateTimeLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateTimeLineMapper extends BaseMapper<UpdateTimeLine> {

    /**
     * 查询系统更新日志时间线
     *
     * @return list
     */
    List<UpdateTimeLine> getUpdateTimeLines();

}
