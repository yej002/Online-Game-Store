package com.jing.storeweb.service.impl;

import com.jing.storeweb.entity.Product;
import com.jing.storeweb.mapper.ProductMapper;
import com.jing.storeweb.service.IProductService;
import com.jing.storeweb.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** This class implements the service methods from product service interface */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     * Return the list of most popular 6 products
     * @return the list of most popular 6 products
     */
    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        for (Product product : list) {
            // initialize properties to null
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }
        return list;
    }


    /**
     * Return the detailed product by product id
     * @param id product id
     * @return the detailed product by product id, return null if not found
     */
    @Override
    public Product findById(Integer id) {
        Product product = productMapper.findById(id);
        // if the product does not exist, throw exception
        if (product == null) {
            throw new ProductNotFoundException("The product cannot be found.");
        }
        // initialize properties to null
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);
        return product;
    }
}
