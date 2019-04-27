package com.xiaoyang.order.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

/**
 * @author WXY
 */
@Setter
@Getter
@Builder
public class Order implements Serializable {

    Integer id;
    String orderCode;
    Integer commodityId;
    String paymentAmount;
    Date createTime;

}
