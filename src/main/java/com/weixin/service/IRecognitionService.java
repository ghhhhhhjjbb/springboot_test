package com.weixin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weixin.pojo.Recognition;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liHeWei
 * @since 2021-11-06
 */
public interface IRecognitionService extends IService<Recognition> {
    int write(Recognition recognition);
    Map<String,Object> queryAll(QueryWrapper<Recognition> wrapper);
    List<Recognition> queryByDay(String dateTime);
    List<Recognition> queryByPlace(String place);
    List<Recognition> queryByDayAndPlace(String dateTime,String place);
}

