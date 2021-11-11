package com.weixin.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liHeWei
 * @since 2021-11-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recognition{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "reId")
    @JsonProperty("_id")
    private String reId;

    /**
     * 地点
     */
    @TableField("place")
    @JsonProperty("地点")
    private String place;

    /**
     * 日期
     */
    @TableField("date")
    @JsonProperty("记录时间")
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date date;

    /**
     * 载数量
     */
    @TableField("InNumber")
    @JsonProperty("未载人数")
    private Integer InNumber;

    /**
     * 开放id
     */
    @TableField("opId")
    @JsonProperty("_openid")
    private String opId;

    /**
     * 未载人数
     */
    @TableField("outNumber")
    @JsonProperty("载人数")
    private Integer outNumber;

    /**
     * 检测图片数
     */
    @TableField("picNum")
    @JsonProperty("检测图片数")
    private Integer picNum;

    /**
     * 开始时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField(exist = false)
    @JsonFormat(pattern = "yyyy年MM月dd日")
    private Date endTime;

}
