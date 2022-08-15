package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.User;
import com.jing.storeweb.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class represents the Junit test and integration test for the user mapper class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    // MyBatis could dynamically creat bean for userMapper
    @Autowired
    private UserMapper userMapper;


    /**
     * Test for insert user data in database, result should be 1, and data should be seen in MySQL database
     */
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user01");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for find user by username, result should be the user matched
     */
    @Test
    public void findByUsername() {
        String username = "user02";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }

    /**
     * Test for update user password by user id, result should be 1
     */
    @Test
    public void updatePasswordByUid() {
        Integer uid = 7;
        String password = "654321";
        String modifiedUser = "user";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for find user by user id, result should be the user matched
     */
    @Test
    public void findByUid() {
        Integer uid = 7;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    /**
     * Test for updating user information, result should be 1, and information should be seen in database
     */
    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(5);
        user.setPhone("6125171234");
        user.setEmail("someuser@gmail.com");
        user.setGender(1);
        user.setModifiedUser("admin");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for update avatar by user id, result should be 1, and path should be seen in database
     */
    @Test
    public void updateAvatarByUid() {
        Integer uid = 20;
        String avatar = "/upload/avatar.png";
        String modifiedUser = "normal user";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
        System.err.println("rows=" + rows);
    }
}


