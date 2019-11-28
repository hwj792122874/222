package com.imooc.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ResultEnum {
    param_error(1,"参数不正确"),
    product_not_exist(10,"商品不存在"),
    product_stock_error(11,"商品库存不足"),
    order_not_exist(12,"订单不存在"),
    orderdetail_not_exist(13,"订单详情不存在"),
    order_status_error(14,"订单状态不正确"),
    order_update_fail(15,"订单更新失败"),
    order_detail_empty(16,"订单详情为空"),
    order_pay_status_error(17,"订单支付状态不正确"),
    cart_empty(18,"购物车为空"),
    order_owner_error(19,"该订单不属于当前用户"),
    ;
    private Integer code;
    private String  message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
