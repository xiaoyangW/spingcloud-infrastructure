package com.xiaoyang.order.mapper;

import com.xiaoyang.order.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author WXY
 */
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 添加订单信息
     *
     * @param order 订单信息
     * @return 影响行
     */
    @Insert("insert into order(order_code,commodity_id,payment_amount,create_time) values(#{orderCode},#{commodityId},#{paymentAmount},#{createTime})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    Integer addOrder(Order order);

    @Select("select id, order_code orderCode,commodityId,paymentAmount,createTime from order where id=#{id}")
    Optional<Order> getOrderInfoById(Integer id);
}
