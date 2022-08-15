package com.jing.storeweb.service;

import com.jing.storeweb.vo.CartVO;

import java.util.List;

/**
 * This interface represents the methods of services that shopping cart should have
 */
public interface ICartService {
    /**
     * Add product to shopping cart
     * @param uid user id
     * @param pid product id
     * @param amount number of product
     * @param username username
     */
    void addToCart(Integer uid, Integer pid, Integer amount, String username);

    /**
     * Find and return object(data) for shopping cart by user id
     * @param uid user id
     * @return The list of object in shopping cart
     */
    List<CartVO> getVOByUid(Integer uid);

    /**
     * Return the result of increment number of products in shopping cart
     * @param cid cart id
     * @param uid user id
     * @param username username
     * @return the result of increment number of products in shopping cart
     */
    Integer addNum(Integer cid, Integer uid, String username);

    /**
     * Return the result of decrement number of products in shopping cart
     * @param cid cart id
     * @param uid user id
     * @param username username
     * @return the result of decrement number of products in shopping cart
     */
    Integer reduceNum(Integer cid, Integer uid, String username);

    /**
     * Find and return value object(data) for shopping carts by multiple cart ids
     * @param uid user id
     * @param cids a list of cart ids
     * @return return a list of object(data) for shopping carts
     */
    List<CartVO> getVOByCids(Integer uid, Integer[] cids);
}
