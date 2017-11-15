package com.xing.fee.domain;

import java.util.Date;

/**
 * Created by dllo on 17/11/15.
 */
public class Fee {
    /**资费Id*/
    private int feeId;
    /**
     * 资费种类
     * 1 包月
     * 2 包小时
     * 3 按小时计算
     **/
    private int feeKind;
    /**资费名称*/
    private String feeName;
    /**基本时长*/
    private String basicTime;
    /**基本费用*/
    private String basicCost;
    /**单位费用*/
    private String unitCost;
    /**创建时间*/
    private Date newTime;
    /**开通时间*/
    private Date openTime;


}
