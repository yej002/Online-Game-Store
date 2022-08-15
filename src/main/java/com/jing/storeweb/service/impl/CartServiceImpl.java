package com.jing.storeweb.service.impl;

import com.jing.storeweb.entity.Cart;
import com.jing.storeweb.entity.Product;
import com.jing.storeweb.mapper.CartMapper;
import com.jing.storeweb.service.ICartService;
import com.jing.storeweb.service.IProductService;
import com.jing.storeweb.service.exceptions.AccessDeniedException;
import com.jing.storeweb.service.exceptions.CartNotFoundException;
import com.jing.storeweb.service.exceptions.InsertException;
import com.jing.storeweb.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * This class implements the service methods from cart service interface
 */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private IProductService productService;


    /**
     * Add product to shopping cart
     * @param uid user id
     * @param pid product id
     * @param amount number of product
     * @param username username
     */
    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        // find the product in cart by user id and product id
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        Date now = new Date();
        // if the result is null, means the product is not in cart, then create the cart with product
        if (result == null) {
            Cart cart = new Cart();
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);

            Product product = productService.findById(pid);
            cart.setPrice(product.getPrice());

            cart.setCreatedUser(username);
            cart.setCreatedTime(now);
            cart.setModifiedUser(username);
            cart.setModifiedTime(now);
            // Insert the cart to database
            Integer rows = cartMapper.insert(cart);
            // if result is not 1, throw exception
            if (rows != 1) {
                throw new InsertException("Failed to update your shopping cart, please try again later.");
            }
        }
        // if the result is not null, means the product is in cart, then update the cart
        else {
            Integer cid = result.getCid();
            // update the product number by adding original num and amount
            Integer num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
            // if result is not 1, throw exception
            if (rows != 1) {
                throw new InsertException("Failed to update your shopping cart, please try again later.");
            }
        }
    }


    /**
     * Find and return object(data) for shopping cart by user id
     * @param uid user id
     * @return The list of object in shopping cart
     */
    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }


    /**
     * Return the result of increment number of products in shopping cart
     * @param cid cart id
     * @param uid user id
     * @param username username
     * @return the result of increment number of products in shopping cart
     */
    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        // if the result for cart is null, throw exception
        if (result == null) {
            throw new CartNotFoundException("The shopping cart cannot be found.");
        }
        // if user id is not equals to cart's user id, throw exception
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied.");
        }
        // increment the number of product in shopping cart
        Integer num = result.getNum() + 1;
        Date now = new Date();
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        // if result is not 1, throw exception
        if (rows != 1) {
            throw new InsertException("Failed to update your shopping cart, please try again later.");
        }
        return num;
    }


    /**
     * Return the result of decrement number of products in shopping cart
     * @param cid cart id
     * @param uid user id
     * @param username username
     * @return the result of decrement number of products in shopping cart
     */
    @Override
    public Integer reduceNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        // if the result for cart is null, throw exception
        if (result == null) {
            throw new CartNotFoundException("The shopping cart cannot be found.");
        }
        // if user id is not equals to cart's user id, throw exception
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied.");
        }
        // decrement the number of product in shopping cart
        Integer num = result.getNum() - 1;
        Date now = new Date();
        Integer rows = cartMapper.updateNumByCid(cid, num, username, now);
        // if result is not 1, throw exception
        if (rows != 1) {
            throw new InsertException("Failed to update your shopping cart, please try again later.");
        }
        return num;
    }


    /**
     * Find and return value object(data) for shopping carts by multiple cart ids
     * @param uid user id
     * @param cids a list of cart ids
     * @return return a list of object(data) for shopping carts
     */
    @Override
    // use iterator design from the class CS5004
    public List<CartVO> getVOByCids(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCids(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()) {
            CartVO cart = it.next();
            // cart's uid should equal to the current uid
            if (!cart.getUid().equals(uid)) {
                it.remove();
            }
        }
        return list;
    }
}
