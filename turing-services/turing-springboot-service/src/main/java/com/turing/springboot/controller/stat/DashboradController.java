package com.turing.springboot.controller.stat;

import com.turing.springboot.dto.resp.stat.DashboradStatDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springcloud.turing.framework.starter.convention.result.Result;
import org.springcloud.turing.framework.starter.log.annotation.ILog;
import org.springcloud.turing.framework.starter.web.Results;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.springcloud.turing.framework.starter.common.utils.DataGenerateUtils.selectRandomArrays;
import static org.springcloud.turing.framework.starter.common.utils.DateTimeUtils.getGenerateDate;

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
     * @param dateStr
     */
    @ILog
    @PostMapping("/dashborad/summary/{dateStr}")
    @ResponseBody
    public Result<DashboradStatDTO> featchDasoboradStat(@PathVariable("dateStr") String dateStr) {
        DashboradStatDTO dashboradStatDTO =  generateDashboradDtoList().get(0);
        System.out.println("路径上的占位符的值=" + dateStr);

        return Results.success(dashboradStatDTO);
    }

    public List<DashboradStatDTO> generateDashboradDtoList() {
        List<DashboradStatDTO> dashboradStatDtoList = new ArrayList<>();
        String[] indexNameArr = {"GMV", "MAU", "Cost", "Revenue"};

        for (int i=0; i<10; i++) {
            try {
                DashboradStatDTO dashboradStatDTO = new DashboradStatDTO();
                dashboradStatDTO.setIndexName(selectRandomArrays(indexNameArr, 1)[0]);
                dashboradStatDTO.setDateTime(getGenerateDate("2023-12-1 00:00:00","2023-12-10 00:00:00", 1));
                dashboradStatDtoList.add(dashboradStatDTO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return dashboradStatDtoList;
    }

}
