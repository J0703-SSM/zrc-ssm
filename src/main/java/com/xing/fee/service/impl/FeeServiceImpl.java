package com.xing.fee.service.impl;

import com.xing.base.domain.PageBean;
import com.xing.fee.domain.Fee;
import com.xing.fee.mapper.FeeMapper;
import com.xing.fee.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dllo on 17/11/15.
 */
@Service("feeService")
public class FeeServiceImpl implements FeeService {
    @Qualifier("feeMapper")
    @Autowired
    private FeeMapper feeMapper;
    @Override
    public void addFee(Fee fee) {
        feeMapper.addFee(fee);
    }

    @Override
    public List<Fee> findAllFee() {
        return feeMapper.findAllFee();
    }

    @Override
    public List<Fee> findFeeOrderByDESC() {
        return feeMapper.findFeeOrderByDESC();
    }

    @Override
    public int deleteFeeById(int feeId) {
        return feeMapper.deleteFeeById(feeId);
    }

    @Override
    public PageBean<Fee> findAllFeeByPage(PageBean<Fee> pageBean) {
        // 存储总记录数
        pageBean.setTotalRecode(feeMapper.findAllFeeCount());
        // 存储查询开始的位置
        pageBean.setStart((pageBean.getPageCode() - 1) * pageBean.getPageSize());
        // 存储查询出来的fee集合
        pageBean.setBeanList(feeMapper.findAllFeeByPage(pageBean));
        return pageBean;
    }

    @Override
    public int openFee(Fee fee) {
        return feeMapper.openFee(fee);
    }
}
