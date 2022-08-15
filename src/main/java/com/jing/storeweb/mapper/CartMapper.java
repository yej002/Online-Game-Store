package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Cart;
import com.jing.storeweb.vo.CartVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/** This interface design the command for shopping cart writing in to SQL */
public interface CartMapper {
    /**
     * Return the result of insert products in to shopping cart
     * @param cart shopping cart
     * @return the result of insert products in to shopping cart
     */
    Integer insert(Cart cart);

    /**
     * Return the result of modified shopping cart
     * @param cid cart id
     * @param num number of product
     * @param modifiedUser modified user
     * @param modifiedTime last modified time
     * @return the result of modified shopping cart
     */
    Integer updateNumByCid(
            @Param("cid") Integer cid,
            @Param("num") Integer num,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * Return the shopping cart by user id and product id
     * @param uid user id
     * @param pid product id
     * @return the shopping cart by user id and product id
     */
    Cart findByUidAndPid(
            @Param("uid") Integer uid,
            @Param("pid") Integer pid);

    /**
     * Find the list of cart content by user id
     * @param uid user id
     * @return the list of cart content by user id
     */
     List<CartVO> findVOByUid(Integer uid);

    /**
     * Find the shopping cart by cart id
     * @param cid cart id
     * @return the shopping cart by cart id
     */
    Cart findByCid(Integer cid);

    /**
     * Find the list of cart content by multiple cart ids
     * @param cids cart ids
     * @return the list of cart content by multiple cart ids
     */
    List<CartVO> findVOByCids(Integer[] cids);
}
