package com.turing.springboot.controller.stat;

import com.turing.springboot.dto.resp.stat.DashboradStatDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springcloud.turing.framework.starter.convention.result.Result;
import org.springcloud.turing.framework.starter.log.annotation.ILog;
import org.springcloud.turing.framework.starter.web.Results;
import org.springframework.web.bind.annotation.*;

/**
 * @descri: 用户管理模块
 *
 * @author: lj.michale
 * @date: 2023/12/14 10:47
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/turing/stat")
public class DashboradController {

    /**
     * 数据统计-首页概览
     *
     * @param dataStr
     */
    @ILog
    @PostMapping("/dashborad")
    @ResponseBody
    public Result<DashboradStatDTO> featchDasoboradStat(@RequestBody String dataStr) {
        DashboradStatDTO dashboradStatDTO = new DashboradStatDTO();

        return Results.success(dashboradStatDTO);
    }


}
