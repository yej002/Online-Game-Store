package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/**
 * This class represents the Junit test and integration test for the product mapper class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;

    /**
     * Test for find the top 6 products sorted by priority, result should be a list of top 6 priority products
     */
    @Test
    public void findHotList() {
        List<Product> list = productMapper.findHotList();
        System.out.println("count=" + list.size());
        for (Product item : list) {
            System.out.println(item);
        }
    }

    /**
     * Test for find product by product id, result should be the product matched
     */
    @Test
    public void findById() {
        Integer id = 10000001;
        Product result = productMapper.findById(id);
        System.out.println(result);
    }
}
