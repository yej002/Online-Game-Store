package com.jing.storeweb.mapper;

import com.jing.storeweb.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * This Interface design the address that going to be written in to SQL
 */
public interface AddressMapper {
    /**
     * Return the result of insert the address
     * @param address address
     * @return the result of insert the address
     */
    Integer insert(Address address);

    /**
     * Return the count of address by user id
     * @param uid user id
     * @return the count of address by user id
     */
    Integer countByUid(Integer uid);

    /**
     * Return the list of address by user id
     * @param uid user id
     * @return the list of address by user id
     */
    List<Address> findByUid(Integer uid);


    /**
     * Return the result of update address to not default
     * @param uid user id
     * @return the result of update address to not default
     */
    Integer updateNonDefaultByUid(Integer uid);

    /**
     * Return the result of update address to default
     * @param aid address id
     * @param modifiedUser modified user
     * @param modifiedTime modified time
     * @return the result of update address to default
     */
    Integer updateDefaultByAid(
            @Param("aid") Integer aid,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);

    /**
     * Return the matched address by address id
     * @param aid address id
     * @return the matched address by address id
     */
    Address findByAid(Integer aid);

    /**
     * Return the result of delete address by address id
     * @param aid address id
     * @return the result of delete address by address id
     */
    Integer deleteByAid(Integer aid);

    /**
     * Return the address which is last modified
     * @param uid user id
     * @return the address which is last modified
     */
    Address findLastModified(Integer uid);

}

