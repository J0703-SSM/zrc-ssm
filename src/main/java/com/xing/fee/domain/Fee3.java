package com.xing.fee.domain;

import com.xing.fee.validationGroup.ValidationGroup1;
import com.xing.fee.validationGroup.ValidationGroup2;
import com.xing.fee.validationGroup.ValidationGroup3;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by dllo on 17/11/15.
 */
public class Fee3 {
    /**资费Id*/
    private int feeId;
    /**
     * 资费种类
     * 1 包月
     * 2 包小时
     * 3 按小时计算
     **/
    private int feeKind;
    /**
     * 开通状态
     * 0 未激活
     * 1 已激活
     **/
    private int state;
    /**资费名称*/
    @NotBlank(message = "名称不能为空")
    private String feeName;
    /**基本时长*/
    private String basicTime;
    /**基本费用*/
    private String basicCost;
    /**单位费用*/
    @Pattern(regexp = "^([1-9]\\d*|0)(\\.\\d{1,2})?$",message = "保留两位小数,且不能为0")
    @Range(min = 0,max = 99999,message = "请输入0-99999之间的数")
    private String unitCost;
    /**创建时间*/
    private Date newTime;
    /**开通时间*/
    private Date openTime;
    /**资费说明*/
    private String content;

    public Fee3() {
    }

    @Override
    public String toString() {
        return "Fee{" +
                "feeId=" + feeId +
                ", feeKind=" + feeKind +
                ", state=" + state +
                ", feeName='" + feeName + '\'' +
                ", basicTime='" + basicTime + '\'' +
                ", basicCost='" + basicCost + '\'' +
                ", unitCost='" + unitCost + '\'' +
                ", newTime=" + newTime +
                ", openTime=" + openTime +
                ", content='" + content + '\'' +
                '}';
    }

    public int getFeeId() {
        return feeId;
    }

    public void setFeeId(int feeId) {
        this.feeId = feeId;
    }

    public int getFeeKind() {
        return feeKind;
    }

    public void setFeeKind(int feeKind) {
        this.feeKind = feeKind;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getFeeName() {
        return feeName;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public String getBasicTime() {
        return basicTime;
    }

    public void setBasicTime(String basicTime) {
        this.basicTime = basicTime;
    }

    public String getBasicCost() {
        return basicCost;
    }

    public void setBasicCost(String basicCost) {
        this.basicCost = basicCost;
    }

    public String getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(String unitCost) {
        this.unitCost = unitCost;
    }

    public Date getNewTime() {
        return newTime;
    }

    public void setNewTime(Date newTime) {
        this.newTime = newTime;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
