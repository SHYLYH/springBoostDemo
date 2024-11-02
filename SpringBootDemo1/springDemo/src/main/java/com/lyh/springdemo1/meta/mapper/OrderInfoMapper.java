package com.lyh.springdemo1.meta.mapper;

import com.lyh.springdemo1.meta.bean.OrderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author lyh
 * @since 2024-11-01
 */
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

}
