package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(7);
        address.setName("test2");
        address.setPhone("9377824444");
        address.setAddress("55 9th Street");
        Integer rows = addressMapper.insert(address);
        System.out.println("rows=" + rows);

        Address address2 = new Address();
        address2.setUid(6);
        address2.setName("test1");
        address2.setPhone("9377823333");
        address2.setAddress("55 9th Street");
        Integer rows2 = addressMapper.insert(address2);
        System.out.println("rows=" + rows2);
    }

    @Test
    public void countByUid() {
        Integer uid = 7;
        Integer count = addressMapper.countByUid(uid);
        System.out.println("count=" + count);
    }

    @Test
    public void findByUid() {
        Integer uid = 7;
        List<Address> list = addressMapper.findByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void updateNonDefaultByUid() {
        Integer uid = 7;
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateDefaultByAid() {
        Integer aid = 1;
        String modifiedUser = "test02";
        Date modifiedTime = new Date();
        Integer rows = addressMapper.updateDefaultByAid(aid, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByAid() {
        Integer aid = 1;
        Address result = addressMapper.findByAid(aid);
        System.out.println(result);
    }

    @Test
    public void deleteByAid() {
        Integer aid = 1;
        Integer rows = addressMapper.deleteByAid(aid);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findLastModified() {
        Integer uid = 7;
        Address result = addressMapper.findLastModified(uid);
        System.out.println(result);
    }
}
