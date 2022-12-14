package com.jing.storeweb.service;

import com.jing.storeweb.entity.Product;

import java.util.List;

/**
 * This interface represents the methods of services that product should have
 */
public interface IProductService {
    /**
     * Return the list of most popular 6 products
     *
     * @return the list of most popular 6 products
     */
    List<Product> findHotList();

    /**
     * Return the detailed product by product id
     *
     * @param id product id
     * @return the detailed product by product id, return null if not found
     */
    Product findById(Integer id);
}
