package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/*
* 商品名字
* */
@Data
public class ProductVO {
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryype;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

}
