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

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
    // MyBatis could dynamically creat bean for userMapper
    @Autowired
    private UserMapper userMapper;


    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user01");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "user02";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }

    @Test
    public void updatePasswordByUid() {
        Integer uid = 7;
        String password = "654321";
        String modifiedUser = "normal user";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 7;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(20);
        user.setPhone("6125171234");
        user.setEmail("someuser@gmail.com");
        user.setGender(1);
        user.setModifiedUser("system manager");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        System.out.println("rows=" + rows);
    }

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


