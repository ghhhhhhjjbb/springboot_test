package com.weixin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weixin.pojo.Recognition;
import com.weixin.service.IRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liHeWei
 * @since 2021-11-06
 */
@RestController
public class RecognitionController {
    @Autowired
    private IRecognitionService iRecognitionService;
    @RequestMapping("/write")
    public Map<String,Object> write(@RequestBody Recognition recognition){
        Map<String,Object> resultMap=new HashMap<>();
        iRecognitionService.write(recognition);
        resultMap.put("result", "写入成功");
        return resultMap;
    }
    @RequestMapping("/writeByArray")
    public Map<String,Object> write(@RequestBody List<Recognition> viewRecognition){
        Map<String,Object> resultMap=new HashMap<>();
        for(Recognition recognition:viewRecognition){
            iRecognitionService.write(recognition);
        };
        resultMap.put("result", "写入成功");
        return resultMap;
    }
    @RequestMapping("/read")
    public Map<String,Object> read(@RequestBody Recognition recognition){
        QueryWrapper<Recognition> wrapper = new QueryWrapper<>();
        if(recognition!=null){
            if(recognition.getPlace()!=null) wrapper.eq("place", recognition.getPlace());
            if(recognition.getDate()!=null) wrapper.eq("date", recognition.getDate());
            if(recognition.getStartTime()!=null&&recognition.getEndTime()!=null){
                wrapper.ge("date", recognition.getStartTime());
                wrapper.le("date", recognition.getEndTime());
            }
        }
        return iRecognitionService.queryAll(wrapper);
    }
}

