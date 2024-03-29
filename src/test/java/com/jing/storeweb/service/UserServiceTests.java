package com.jing.storeweb.service;

import com.jing.storeweb.entity.User;
import com.jing.storeweb.service.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * This class represents the Junit test and integration test for the user service class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService iUserService;

    /**
     * Test for register user, result should be success, and data should be seen in database
     * Otherwise, throw exception
     */
    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("user03");
            user.setPassword("123456");
            user.setGender(1);
            user.setPhone("9371234567");
            user.setEmail("user03@gmail.com");
            user.setAvatar("avatar.png");
            iUserService.reg(user);
            System.out.println("success.");
        } catch (ServiceException e) {
            System.out.println("Registration failed! " + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for login with username and password, result should be success.
     * Otherwise, throw exception
     */
    @Test
    public void login() {
        try {
            String username = "user03";
            String password = "123456";
            User user = iUserService.login(username, password);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println("Failed for login. " + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for change password for user, result should be success
     * otherwise, throw exception
     */
    @Test
    public void changePassword() {
        try {
            Integer uid = 3;
            String username = "user03";
            String oldPassword = "123456";
            String newPassword = "888888";
            iUserService.changePassword(uid, username, oldPassword, newPassword);
            System.out.println("Success！");
        } catch (ServiceException e) {
            System.out.println("Password update failed！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for get user by user id, result should be the user matched
     * Otherwise, throw exception
     */
    @Test
    public void getByUid() {
        try {
            Integer uid = 3;
            User user = iUserService.getByUid(uid);
            System.out.println(user);
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for change information for user, result should be success
     * Otherwise, throw exception
     */
    @Test
    public void changeInfo() {
        try {
            Integer uid = 3;
            String username = "user03";
            User user = new User();
            user.setPhone("6281234567");
            user.setEmail("user@gmail.com");
            user.setGender(0);
            iUserService.changeInfo(uid, username, user);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println("Information update failed！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for change avatar for user, result should be success
     * Otherwise, throw exception
     */
    @Test
    public void changeAvatar() {
        try {
            Integer uid = 4;
            String username = "user02";
            String avatar = "/upload/avatar.png";
            iUserService.changeAvatar(uid, username, avatar);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println("Avatar update failed！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}

