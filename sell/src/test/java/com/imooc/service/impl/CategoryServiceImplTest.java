package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import com.imooc.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
@Autowired
private CategoryService categoryService;
    @Test
     public void findOne() {
        ProductCategory productCategory=categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
        System.out.println(productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> all = categoryService.findAll();
        Assert.assertNotEquals(0,all.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(Arrays.asList(2,3,5));
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory=new ProductCategory("男生专享",10);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotEquals(null,result);
    }
}