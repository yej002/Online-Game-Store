package com.jing.storeweb.controller;

import com.jing.storeweb.entity.Address;
import com.jing.storeweb.service.IAddressService;
import com.jing.storeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * This class defined the controller of the Address
 * It takes the requests for address, and sends response to front-end
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    /**
     * @param address address input from frontend
     * @param session session that contains user information
     * @return JsonResult that state success
     */
    @RequestMapping("add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
        // get user id and username from session
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<>(OK);
    }

    /**
     * @param session Session that contains user information
     * @return JsonResult that state ok and user data from backend
     */
    @GetMapping({"", "/"})
    public JsonResult<List<Address>> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<>(OK, data);
    }

    /**
     * @param aid     address id
     * @param session Session that contains user information
     * @return JsonResult that state success
     */
    @RequestMapping("{aid}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.setDefault(aid, uid, username);
        return new JsonResult<>(OK);
    }

    /**
     * @param aid     address id
     * @param session Session that contains user information
     * @return JsonResult that state success
     */
    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.delete(aid, uid, username);
        return new JsonResult<>(OK);
    }

}

