package com.xiaoyang.order.mapper;

import com.xiaoyang.order.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.Optional;

/**
 * @author WXY
 */
@Mapper
public interface OrderMapper {
    /**
     * 添加订单信息
     * @param order 订单信息
     * @return 影响行
     */
    @Insert("insert into order(order_code,commodity_id,payment_amount,create_time) values(#{orderCode},#{commodityId},#{paymentAmount},#{createTime})")
    @Options(useGeneratedKeys=true, keyColumn = "id", keyProperty = "id")
    Optional<Boolean> addOrder(Order order);

}
