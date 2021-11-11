package com.weixin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weixin.pojo.Recognition;
import com.weixin.mapper.RecognitionMapper;
import com.weixin.service.IRecognitionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liHeWei
 * @since 2021-11-06
 */
@Service
public class RecognitionServiceImpl extends ServiceImpl<RecognitionMapper, Recognition> implements IRecognitionService {
    @Autowired
    private RecognitionMapper recognitionMapper;

    @Override
    public int write(Recognition recognition) {
        return recognitionMapper.insert(recognition);
    }

    @Override
    public Map<String,Object> queryAll(QueryWrapper<Recognition> wrapper) {
        Map<String,Object> map=new HashMap<>();
        Map<String,Object> map1=new HashMap<>();
        List<Recognition> list=recognitionMapper.selectList(wrapper);
        if(list.isEmpty()) {
            map.put("message","查询为空");
            map.put("state", 200);
        }
        else {
            map.put("message","查询成功");
            map.put("state", 400);
        }
        int sumPic=0;
        int sumInNumber=0;
        int sumOutNumber=0;
        for(Recognition re:list){
            sumPic+=re.getPicNum();
            sumInNumber+=re.getInNumber();
            sumOutNumber+= re.getOutNumber();
        }
        map1.put("总检测图片数", sumPic);
        map1.put("总载人数", sumInNumber);
        map1.put("总未载人数", sumOutNumber);
        map1.put("result", list);
        map.put("data", map1);
        return map;
    }
    @Override
    public List<Recognition> queryByDay(String dateTime) {
        Map<String,Object> map=new HashMap<>();
        map.put("date", dateTime);
        return recognitionMapper.selectByMap(map);
    }

    @Override
    public List<Recognition> queryByPlace(String place) {
        Map<String,Object> map=new HashMap<>();
        map.put("place", place);
        return recognitionMapper.selectByMap(map);
    }

    @Override
    public List<Recognition> queryByDayAndPlace(String dateTime,String place) {
        Map<String,Object> map=new HashMap<>();
        map.put("place", place);
        map.put("date", dateTime);
        return recognitionMapper.selectByMap(map);
    }
}
