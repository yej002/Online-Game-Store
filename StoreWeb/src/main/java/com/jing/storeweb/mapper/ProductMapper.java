package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Product;

import java.util.List;

/** This interface design the command for product writing in to SQL */
public interface ProductMapper {
    /**
     * Return the list of most popular 4 products
     * @return the list of most popular 4 products
     */
    List<Product> findHotList();

    /**
     * Return the detailed product by product id
     * @param id product id
     * @return the detailed product by product id, return null if not found
     */
    Product findById(Integer id);
}
