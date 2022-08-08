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

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert() {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(10000013);
        cart.setNum(30);
        cart.setPrice(400L);
        Integer rows = cartMapper.insert(cart);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateNumByCid() {
        Integer cid = 1;
        Integer num = 10;
        String modifiedUser = "user01";
        Date modifiedTime = new Date();
        Integer rows = cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUidAndPid() {
        Integer uid = 2;
        Integer pid = 10000012;
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        System.out.println(result);
    }

    @Test
    public void findVOByUid() {
        List<CartVO> list = cartMapper.findVOByUid(9);
        System.out.println(list);
    }

    @Test
    public void findByCid() {
        Integer cid = 6;
        Cart result = cartMapper.findByCid(cid);
        System.out.println(result);
    }

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
