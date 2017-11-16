package com.xing.fee.mapper;

import com.xing.base.domain.PageBean;
import com.xing.fee.domain.Fee;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface FeeMapper {
    /**
     * 添加一个资费信息
     * @param fee 传入的资费信息
     */
    void addFee(Fee fee);
    /**
     * 查询所有
     */
    List<Fee> findAllFee();
    /**
     * 降序排序
     */
    List<Fee> findFeeOrderByDESC();
    /**
     * 查询Fee的总记录数
     */
    int findAllFeeCount();

    /**
     * 根据page信息进行分页查询
     */
    List<Fee> findAllFeeByPage(PageBean<Fee> pageBean);

    /**
     * 根据Id删除Fee
     * @param feeId 传入的Fee的ID
     * @return 返回删除条数,如果为0则删除失败
     */
    int deleteFeeById(int feeId);
    /**
     * 启用Fee
     */
    int openFee(Fee fee);
}
