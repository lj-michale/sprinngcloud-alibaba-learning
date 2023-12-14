package com.turing.springboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.turing.springboot.dao.entity.UpdateTimeLine;
import com.turing.springboot.dao.entity.UpdateTimeLineVo;


import java.util.List;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-09-05
 */
public interface UpdateTimeLineServer extends IService<UpdateTimeLine> {

    List<UpdateTimeLineVo> getUpdateTimeLines();

}
