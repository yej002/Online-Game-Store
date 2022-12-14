package com.jing.storeweb.controller;

import com.jing.storeweb.controller.exceptions.*;
import com.jing.storeweb.service.exceptions.*;
import com.jing.storeweb.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * This class defined the common elements of the controller
 */
public class BaseController {
    /**
     * request response success, code 200
     */
    public static final int OK = 200;

    /**
     * get user id from HttpSession
     *
     * @param session HttpSession object
     * @return user id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * get username from HttpSession
     *
     * @param session HttpSession object
     * @return username
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    /**
     * @ExceptionHandler Used to uniformly handle exceptions thrown by methods
     */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
        } else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
        } else if (e instanceof CartNotFoundException) {
            result.setState(4007);
        } else if (e instanceof InsertException) {
            result.setState(5000);
        } else if (e instanceof UpdateException) {
            result.setState(5001);
        } else if (e instanceof DeleteException) {
            result.setState(5002);
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }
}
