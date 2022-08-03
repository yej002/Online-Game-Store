package com.jing.storeweb.service;

import com.jing.storeweb.entity.Address;
import java.util.List;

/** This interface represents the services that address should have */

public interface IAddressService {
    /**
     * Create a new address
     * @param uid user id
     * @param username username
     * @param address address
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * Return the list of address for user by user id
     * @param uid user id
     * @return list of address
     */
    List<Address> getByUid(Integer uid);

    /**
     * Set the address to default
     * @param aid address id
     * @param uid user id
     * @param username username
     */
    void setDefault(Integer aid, Integer uid, String username);

    /**
     * Delete the address
     * @param aid address id
     * @param uid user id
     * @param username username
     */
    void delete(Integer aid, Integer uid, String username);

    /**
     * Return the detailed address by address id
     * @param aid address id
     * @param uid user id
     * @return the detailed address by address id
     */
    Address getByAid(Integer aid, Integer uid);
}
