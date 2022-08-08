package com.jing.storeweb.service;

import com.jing.storeweb.entity.User;

/** this interface represents the services that user should have */
public interface IUserService {
    /**
     * user registration
     * @param user user
     */
    void reg(User user);

    /**
     * user log in
     * @param username username
     * @param password password
     * @return matched user
     */
    User login(String username, String password);

    /**
     * change password
     * @param uid user id
     * @param username username
     * @param oldPassword original password
     * @param newPassword new password
     */
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * get matched user information/data by user id
     * @param uid user id
     * @return matched user
     */
    User getByUid(Integer uid);

    /**
     * change user information
     * @param uid user id
     * @param username username
     * @param user user object
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * change user avatar
     * @param uid user id
     * @param username username
     * @param avatar path for the new avatar
     */
    void changeAvatar(Integer uid, String username, String avatar);
}

