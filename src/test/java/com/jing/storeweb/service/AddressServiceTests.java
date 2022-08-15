package com.jing.storeweb.service;

import com.jing.storeweb.entity.Address;
import com.jing.storeweb.service.exceptions.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/**
 * This class represents the Junit test and integration test for the address service class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    /**
     * Test for adding new address, result should be success, address should be seen in database
     * Otherwise, throw exception
     */
    @Test
    public void addNewAddress() {
        try {
            Integer uid = 2;
            String username = "user01";
            Address address = new Address();
            address.setName("Jing Ye");
            address.setPhone("6125177777");
            address.setAddress("55 9th Street");
            addressService.addNewAddress(uid, username, address);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for get address by user id, result should be a list of address matched
     */
    @Test
    public void getByUid() {
        Integer uid = 2;
        List<Address> list = addressService.getByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }

    /**
     * Test for set address to default, result should be success. Otherwise, throw exception
     */
    @Test
    public void setDefault() {
        try {
            Integer aid = 4;
            Integer uid = 2;
            String username = "user01";
            addressService.setDefault(aid, uid, username);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    /**
     * Test for deleting address, result should be success. Otherwise, throw exception
     */
    @Test
    public void delete() {
        try {
            Integer aid = 2;
            Integer uid = 2;
            String username = "user01";
            addressService.delete(aid, uid, username);
            System.out.println("Success.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
