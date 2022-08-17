package com.jing.storeweb.service.impl;

import com.jing.storeweb.entity.User;
import com.jing.storeweb.mapper.UserMapper;
import com.jing.storeweb.service.IUserService;
import com.jing.storeweb.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * This class implements the service methods from user service interface
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;


    /**
     * user registration
     *
     * @param user user
     */
    @Override
    public void reg(User user) {
        // get the username from user
        String username = user.getUsername();
        // check if the user exist by username
        User result = userMapper.findByUsername(username);
        // if result == null, it is valid data
        if (result != null) {
            // if result != null, means data exists, throw UsernameDuplicateException
            throw new UsernameDuplicateException("The username of [" + username + "] is already used.");
        }
        // make a creation time for the user
        Date now = new Date();
        // generate a random unique id to encoding password
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(user.getPassword(), salt);
        // the password in our database is encoded
        user.setPassword(md5Password);
        // complete other data for our database
        user.setSalt(salt);
        user.setIsDelete(0);
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        // check if insert data successful by check the lines it affected to database
        Integer rows = userMapper.insert(user);
        // insert method should have affection of 1 line
        if (rows != 1) {
            throw new InsertException("Failed registration, please try again later.");
        }
    }

    /**
     * encoding the password
     *
     * @param password original password
     * @param salt     encoding key
     * @return password after encoding
     */
    private String getMd5Password(String password, String salt) {
        /*
         * Rules：
         * 1、ignore the complexity of original password
         * 2、using UUID as a secret key, add it to both side of password
         * 3、repeating the encoding process 3 times
         */
        for (int i = 0; i < 3; i++) {
            // md5 algorithm is a cryptographically broken but still widely used hash function producing a 128-bit hash value.
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }


    /**
     * user log in
     *
     * @param username username
     * @param password password
     * @return matched user
     */
    @Override
    public User login(String username, String password) {
        // get the user's information/data from database by username
        User result = userMapper.findByUsername(username);
        // check if the user exist or the information/data was deleted
        if (result == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("User is not found.");
        }
        // get the salt from database, and encoding the password that entered by user
        String salt = result.getSalt();
        String md5Password = getMd5Password(password, salt);
        // check if the password entered is match with database
        if (!result.getPassword().equals(md5Password)) {
            throw new PasswordNotMatchException("The username or password is not match.");
        }
        User user = new User();
        // give information which taken from database to user
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        return user;
    }


    /**
     * change password
     *
     * @param uid         user id
     * @param username    username
     * @param oldPassword original password
     * @param newPassword new password
     */
    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        // check if the user exist or the information/data was deleted
        if (result == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("User is not found.");
        }
        // get the salt from database, and encoding the old password and new password
        String salt = result.getSalt();
        // encoding old password to verify with database
        String oldMd5Password = getMd5Password(oldPassword, salt);
        // if not match, throw exception
        if (!result.getPassword().contentEquals(oldMd5Password)) {
            throw new PasswordNotMatchException("Password is not match.");
        }
        // encoding new password and put it into database
        String newMd5Password = getMd5Password(newPassword, salt);
        Date now = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, newMd5Password, username, now);
        // check if the update success, affected line should be 1
        if (rows != 1) {
            throw new UpdateException("Failed to update your password, please try again later.");
        }
    }


    /**
     * get matched user information/data by user id
     *
     * @param uid user id
     * @return matched user
     */
    @Override
    public User getByUid(Integer uid) {
        // get information/data by user id
        User result = userMapper.findByUid(uid);
        // check if the user exist or the information/data was deleted
        if (result == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("User is not found.");
        }
        User user = new User();
        // give information which taken from database to user
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    /**
     * change user information
     *
     * @param uid      user id
     * @param username username
     * @param user     user object
     */
    @Override
    public void changeInfo(Integer uid, String username, User user) {
        // get information/data by user id
        User result = userMapper.findByUid(uid);
        // check if the user exist or the information/data was deleted
        if (result == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("User is not found.");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        // check if the update success, affected line should be 1
        if (rows != 1) {
            throw new UpdateException("Failed to update your information, please try again later.");
        }
    }

    /**
     * change user avatar
     *
     * @param uid      user id
     * @param username username
     * @param avatar   path for the new avatar
     */
    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        // get information/data by user id
        User result = userMapper.findByUid(uid);
        // check if the user exist or the information/data was deleted
        if (result == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("User is not found.");
        }
        Date now = new Date();
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, now);
        // check if the update success, affected line should be 1
        if (rows != 1) {
            throw new UpdateException("Failed to update your avatar, please try again later.");
        }
    }
}

