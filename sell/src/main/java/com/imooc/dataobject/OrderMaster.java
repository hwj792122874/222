package com.imooc.dataobject;

import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;//买家微信
    private BigDecimal orderAmount;//订单总金额
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();//订单状态
    private Integer payStatus= PayStatusEnum.WAIT.getCode();//支付状态
    private Date createTime;
    private Date updateTime;

}
