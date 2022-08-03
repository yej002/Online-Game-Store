package com.jing.storeweb.service.impl;

import com.jing.storeweb.entity.Address;
import com.jing.storeweb.mapper.AddressMapper;
import com.jing.storeweb.service.IAddressService;
import com.jing.storeweb.service.IDistrictService;
import com.jing.storeweb.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * this class implements the services for address
 */
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;
//    @Autowired
//    private IDistrictService districtService;

    // defined in application properties
    @Value("${user.address.max-count}")
    private int maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        // count the number of address by user id
        Integer count = addressMapper.countByUid(uid);
        // if the number of address exceeds the maximum limit, throw exception
        if (count > maxCount) {
            throw new AddressCountLimitException("The number of address cannot exceeds (" + maxCount + ")！");
        }

        // fill out province information
//        String provinceName = districtService.getNameByCode(address.getProvinceCode());
//        address.setProvinceName(provinceName);


        address.setUid(uid);
        // 0-not default，1-default
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        Date now = new Date();
        address.setCreatedUser(username);
        address.setCreatedTime(now);
        address.setModifiedUser(username);
        address.setModifiedTime(now);

        Integer rows = addressMapper.insert(address);
        // if the result is not equals to 1, throw exception
        if (rows != 1) {
            throw new InsertException("Failed to add your address, please try again later.！");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        return list;
    }

    @Transactional
    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        // Find the address by address id
        Address result = addressMapper.findByAid(aid);
        // if the result is null, throw exception
        if (result == null) {
            throw new AddressNotFoundException("The address cannot be found.");
        }

        // if the address result's user id not equals to @parameter user id, throw exception
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied.");
        }

        // use updateNonDefaultByUid() to set all address to not default
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        // result should greater or equals to 1, if the result less than 1, throw exception
        if (rows < 1) {
            throw new UpdateException("Failed to set your default address, please try again later. ");
        }

        // use updateDefaultByAid() to set an address to default by address id
        rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        // result should equals to 1, if not, throw exception
        if (rows != 1) {
            throw new UpdateException("Failed to set your default address, please try again later. ");
        }
    }

    @Transactional
    @Override
    public void delete(Integer aid, Integer uid, String username) {
        // use findByAid(aid) to find the address
        Address result = addressMapper.findByAid(aid);
        // if result is null, throw exception
        if (result == null) {
            throw new AddressNotFoundException("The address cannot be found.");
        }

        // if the address result's user id not equals to @parameter user id, throw exception
        if (!result.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied.");
        }

        Integer rows1 = addressMapper.deleteByAid(aid);
        // if result for delete is not equals to 1, throw exception
        if (rows1 != 1) {
            throw new DeleteException("Failed to delete your address, please try again later.");
        }

        // check if the result is default
        if (result.getIsDefault() == 0) {
            return;
        }

        // check the number of address remaining for the user
        Integer count = addressMapper.countByUid(uid);
        // if no address remaining, return
        if (count == 0) {
            return;
        }

        // find the last modified address
        Address lastModified = addressMapper.findLastModified(uid);
        // get address id from last modified address
        Integer lastModifiedAid = lastModified.getAid();
        // update the last modified address to default
        Integer rows2 = addressMapper.updateDefaultByAid(lastModifiedAid, username, new Date());
        // if the result is not equals to 1, throw exception
        if (rows2 != 1) {
            throw new UpdateException("Failed to update your address, please try again later.");
        }
    }

    @Override
    public Address getByAid(Integer aid, Integer uid) {
        // get the address by address id
        Address address = addressMapper.findByAid(aid);
        if (address == null) {
            throw new AddressNotFoundException("The address is not found.");
        }
        // if the address result's user id not equals to @parameter user id, throw exception
        if (!address.getUid().equals(uid)) {
            throw new AccessDeniedException("Access Denied");
        }
        return address;
    }
}

