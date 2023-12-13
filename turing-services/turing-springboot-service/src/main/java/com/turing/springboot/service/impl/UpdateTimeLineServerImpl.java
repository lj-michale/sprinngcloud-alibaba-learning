package com.turing.springboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.turing.springboot.dao.model.UpdateTimeLine;
import com.turing.springboot.entity.UpdateTimeLineVo;
import com.turing.springboot.mapper.UpdateTimeLineMapper;
import com.turing.springboot.service.UpdateTimeLineServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @descri
 *
 * @author lj.michale
 * @date 2023-09-05
 */
@Slf4j
@Service
public class UpdateTimeLineServerImpl extends ServiceImpl<UpdateTimeLineMapper, UpdateTimeLine> implements UpdateTimeLineServer {

    @Resource
    private UpdateTimeLineMapper updateTimeLineMapper;

    final static SimpleDateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<UpdateTimeLineVo> getUpdateTimeLines() {
        List<UpdateTimeLineVo> updateTimeLineVos = new ArrayList<>();
        List<UpdateTimeLine> updateTimeLines = updateTimeLineMapper.getUpdateTimeLines();

        Map<String, List<UpdateTimeLineVo>> updateTimeLineMap = new HashMap<>();
        for(UpdateTimeLine updateTimeLine : updateTimeLines) {
            UpdateTimeLineVo updateTimeLineVo = new UpdateTimeLineVo();
            updateTimeLineVo.setId(updateTimeLine.getId());
            updateTimeLineVo.setAction(updateTimeLine.getAction());
            updateTimeLineVo.setAuthor(updateTimeLine.getAuthor());
            updateTimeLineVo.setContext(updateTimeLine.getContext());
            updateTimeLineVo.setCreateBy(updateTimeLine.getCreateBy());
            updateTimeLineVo.setCreateTime(updateTimeLine.getCreateTime());
            updateTimeLineVos.add(updateTimeLineVo);
            // 搜先根据creatTime进行合并,然后进行根据时间排序
            Map<String, List<UpdateTimeLineVo>> map = updateTimeLineVos.stream().collect(
                    Collectors.groupingBy(item -> new SimpleDateFormat("yyyy-MM-dd").format(item.getCreateTime())));
            updateTimeLineMap.putAll(map);
        }

        Iterator<Map.Entry< String,  List<UpdateTimeLineVo> >> iterator = updateTimeLineMap.entrySet().iterator();
        // 清除updateTimeLineVos元素
        updateTimeLineVos.clear();

        while (iterator.hasNext()) {
            Map.Entry<String, List<UpdateTimeLineVo>> entry = iterator.next();

            try {
                Date date = formatter.parse(entry.getKey());
                List<UpdateTimeLineVo> valueList = entry.getValue();
                // 进行合并处理
                StringBuffer author = new StringBuffer();
                StringBuffer action = new StringBuffer();
                StringBuffer context = new StringBuffer();

                for (UpdateTimeLineVo updateTimeLineVo1 : valueList) {
                    author.append(updateTimeLineVo1.getAuthor() + ",");
                    action.append(updateTimeLineVo1.getAction() + ",");
                    context.append(updateTimeLineVo1.getContext() + ",");
                }

                UpdateTimeLineVo updateTimeLineVo2 = new UpdateTimeLineVo();
                updateTimeLineVo2.setAuthor(strQuChong(author.toString().replaceAll(".$", "")));
                updateTimeLineVo2.setAction(strQuChong(action.toString().replaceAll(".$", "")));
                updateTimeLineVo2.setContext(strQuChong(context.toString().replaceAll(".$", "")));
                updateTimeLineVo2.setCreateTime(date);
                updateTimeLineVos.add(updateTimeLineVo2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // 根据日期进行排序
        updateTimeLineVos.sort(Comparator.comparing(UpdateTimeLineVo::getCreateTime).reversed());

        return updateTimeLineVos;
    }


    /**
     * @descri 字符串去重
     * @param str
     */
    private String strQuChong(String str) {
        String[] newArr = Arrays.stream(str.split(",")).distinct().toArray(String[]::new);
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < newArr.length; i++) {
            sb.append(newArr[i].toString() + ",");
        }

        return sb.toString().replaceAll(".$", "");
    }

}