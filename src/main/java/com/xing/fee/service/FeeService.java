package com.xing.fee.service;

import com.xing.base.domain.PageBean;
import com.xing.fee.domain.Fee;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
public interface FeeService {
    void addFee(Fee fee);
    List<Fee> findAllFee();
    List<Fee> findFeeOrderByDESC();
    int deleteFeeById(int feeId);
    PageBean<Fee> findAllFeeByPage(PageBean<Fee> pageBean);
    int openFee(Fee fee);
}
