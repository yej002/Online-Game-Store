package com.jing.storeweb.controller;

import com.jing.storeweb.service.ICartService;
import com.jing.storeweb.util.JsonResult;
import com.jing.storeweb.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
        System.out.println("pid=" + pid);
        System.out.println("amount=" + amount);
        // get uid and username from Session
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // add the parameters to cart
        cartService.addToCart(uid, pid, amount, username);
        return new JsonResult<>(OK);
    }

    @GetMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpSession session) {
        // get uid from Session
        Integer uid = getUidFromSession(session);
        // get object from cart by user id
        List<CartVO> data = cartService.getVOByUid(uid);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // get uid and username from Session
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // add num to object and return it to front-end
        Integer data = cartService.addNum(cid, uid, username);
        return new JsonResult<>(OK, data);
    }

    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // get uid and username from Session
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // add num to object and return it to front-end
        Integer data = cartService.reduceNum(cid, uid, username);
        return new JsonResult<>(OK, data);
    }

    @GetMapping("list")
    public JsonResult<List<CartVO>> getVOByCids(Integer[] cids, HttpSession session) {
        // get user id from Session
        Integer uid = getUidFromSession(session);
        // find cart by uid and cid
        List<CartVO> data = cartService.getVOByCids(uid, cids);
        return new JsonResult<>(OK, data);
    }
}
