package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Cart;
import com.jing.storeweb.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
/**
 * This class represents the Junit test and integration test for the cart mapper class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    /**
     * Test for insert product into shopping cart, result should be 1
     */
    @Test
    public void insert() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(10000001);
        cart.setNum(30);
        cart.setPrice(400L);
        Integer rows = cartMapper.insert(cart);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for update product number in shopping cart, result should be 1
     */
    @Test
    public void updateNumByCid() {
        Integer cid = 1;
        Integer num = 10;
        String modifiedUser = "user01";
        Date modifiedTime = new Date();
        Integer rows = cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for find shopping cart by user id and product id, result should be the cart matched
     */
    @Test
    public void findByUidAndPid() {
        Integer uid = 1;
        Integer pid = 10000002;
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        System.out.println(result);
    }


    /**
     * Test for find cart by cart id, result should be the cart matched
     */
    @Test
    public void findByCid() {
        Integer cid = 6;
        Cart result = cartMapper.findByCid(cid);
        System.out.println(result);
    }

    /**
     * Test for find value object in shopping cart by user id, result should be the list of cart value objects
     */
    @Test
    public void findVOByUid() {
        List<CartVO> list = cartMapper.findVOByUid(9);
        System.out.println(list);
    }


    /**
     * Test for find value object by multiple cart ids, result should be a list of the items in all carts
     */
    @Test
    public void findVOByCids() {
        Integer[] cids = {1, 2, 3};
        List<CartVO> list = cartMapper.findVOByCids(cids);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }
}
