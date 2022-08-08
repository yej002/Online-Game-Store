package com.jing.storeweb.service;

import com.jing.storeweb.service.exceptions.ServiceException;
import com.jing.storeweb.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTests {
    @Autowired
    private ICartService cartService;

    @Test
    public void addToCart() {
        try {
            Integer uid = 2;
            Integer pid = 10000012;
            Integer amount = 5;
            String username = "User02";
            cartService.addToCart(uid, pid, amount, username);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getVOByUid() {
        List<CartVO> list = cartService.getVOByUid(2);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void addNum() {
        try {
            Integer cid = 1;
            Integer uid = 2;
            String username = "user02";
            Integer num = cartService.addNum(cid, uid, username);
            System.out.println("Your item updated to " + num);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getVOByCids() {
        Integer[] cids = {1, 2, 3};
        Integer uid = 2;
        List<CartVO> list = cartService.getVOByCids(uid, cids);
        System.out.println("count=" + list.size());
        for (CartVO item : list) {
            System.out.println(item);
        }
    }

}
