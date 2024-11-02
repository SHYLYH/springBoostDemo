package com.lyh.springdemo1.meta.service.impl;

import com.lyh.springdemo1.meta.bean.OrderInfo;
import com.lyh.springdemo1.meta.mapper.OrderInfoMapper;
import com.lyh.springdemo1.meta.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author lyh
 * @since 2024-11-01
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
