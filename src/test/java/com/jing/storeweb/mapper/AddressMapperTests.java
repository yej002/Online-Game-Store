package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * This class represents the Junit test and integration test for the address mapper class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;

    /**
     * Test for insert method for the address, data should be seen in MySQL database
     */
    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(2);
        address.setName("test2");
        address.setPhone("9377824444");
        address.setCityName("San Fransisco");
        address.setStateName("CA");
        address.setAddress("55 9th Street");
        Integer rows = addressMapper.insert(address);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for count address by user id, result should be 1
     */
    @Test
    public void countByUid() {
        Integer uid = 7;
        Integer count = addressMapper.countByUid(uid);
        System.out.println("count=" + count);
    }

    /**
     * Test for find address list by user id, result should be the list of address
     */
    @Test
    public void findByUid() {
        Integer uid = 7;
        List<Address> list = addressMapper.findByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }

    /**
     * Test for update address to not default, result should be 1
     */
    @Test
    public void updateNonDefaultByUid() {
        Integer uid = 7;
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for update address to default, result should be 1
     */
    @Test
    public void updateDefaultByAid() {
        Integer aid = 1;
        String modifiedUser = "test02";
        Date modifiedTime = new Date();
        Integer rows = addressMapper.updateDefaultByAid(aid, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for find address by address id, result should be the address matched
     */
    @Test
    public void findByAid() {
        Integer aid = 1;
        Address result = addressMapper.findByAid(aid);
        System.out.println(result);
    }

    /**
     * Test for deleting address by address id, result should be 1
     */
    @Test
    public void deleteByAid() {
        Integer aid = 1;
        Integer rows = addressMapper.deleteByAid(aid);
        System.out.println("rows=" + rows);
    }

    /**
     * Test for find last modified address by user id, result should be the address matched
     */
    @Test
    public void findLastModified() {
        Integer uid = 7;
        Address result = addressMapper.findLastModified(uid);
        System.out.println(result);
    }
}
