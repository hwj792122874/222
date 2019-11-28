package com.imooc.service.impl;

import com.imooc.dataobject.ProductInfo;
import com.imooc.enums.ProductStatusEnum;
import com.imooc.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductService productService;

    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("123456");
        Assert.assertEquals("123456",result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest request=PageRequest.of(0,2);
        Page<ProductInfo> result = productService.findAll(request);
        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好吃的虾");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWM.getCode());
        productInfo.setCategoryType(2);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotEquals(null,result);
    }
}