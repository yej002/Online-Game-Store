package com.jing.storeweb.service;

import com.jing.storeweb.entity.Product;
import com.jing.storeweb.service.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/**
 * This class represents the Junit test and integration test for the product service class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTests {
    @Autowired
    private IProductService productService;

    /**
     * Test for find top 6 priority products, result should be the products sorted by priority
     * Otherwise, throw exception
     */
    @Test
    public void findHotList() {
        try {
            List<Product> list = productService.findHotList();
            System.out.println("count=" + list.size());
            for (Product item : list) {
                System.out.println(item);
            }
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for ind product by id, result should be the product matched
     * Otherwise, throw exception
     */
    @Test
    public void findById() {
        try {
            Integer id = 1000002;
            Product result = productService.findById(id);
            System.out.println(result);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
