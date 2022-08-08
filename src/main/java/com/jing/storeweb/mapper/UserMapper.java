package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


/**
 * This Interface design the command writing in to SQL by user's action
 */
public interface UserMapper {
    /**
     * input user information
     * @param user data
     * @return the lines affected by CRUD actions
     */
    Integer insert(User user);

    /**
     * find the user by username
     * @param username the username of the user
     * @return return the user's information, if no matched user, return null
     */
    User findByUsername(String username);

    /**
     * update the password by uid
     * @param uid user's id
     * @param password new password
     * @param modifiedUser last modified user
     * @param modifiedTime last modified time
     * @return the lines affected by update
     */
    Integer updatePasswordByUid(
            @Param("uid") Integer uid,
            @Param("password") String password,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * find user information by user id
     * @param uid user id
     * @return return the user's information, if no matched user, return null
     */
    User findByUid(Integer uid);

    /**
     * update the information by uid
     * @param user object that has all information
     * @return the lines affected by update
     */
    Integer updateInfoByUid(User user);

    /**
     * update the avatar by uid
     * @param uid user id
     * @param avatar path of the new avatar
     * @param modifiedUser last modified user
     * @param modifiedTime last modified time
     * @return the lines affected by update
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
}

