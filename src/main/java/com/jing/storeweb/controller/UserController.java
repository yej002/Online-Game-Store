package com.jing.storeweb.controller;

import com.jing.storeweb.controller.exceptions.*;
import com.jing.storeweb.entity.User;
import com.jing.storeweb.service.IUserService;
import com.jing.storeweb.service.exceptions.InsertException;
import com.jing.storeweb.service.exceptions.UsernameDuplicateException;
import com.jing.storeweb.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** This class defined the controller of user
 * It takes the requests from user, and sends response to front-end
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    /**
     * @param user user
     * @return JsonResult contains status of success for register
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }


    /**
     * @param username username
     * @param password user password
     * @param session session that contains the user information
     * @return the data for user and status of success for login
     */
    @RequestMapping("login")
    // use session to save the data in server that can be accessed
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        // send the result as JsonResult
        return new JsonResult<>(OK, data);
    }

    /**
     * @param oldPassword user old password
     * @param newPassword user new password
     * @param session session that contains user information
     * @return JsonResult that contains status of success for password changing
     */
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(OK);
    }

    /**
     * @param session session that contains user information
     * @return JsonResult that contains user data and status of success
     */
    // use AJAX to fill out information to front-end
    @GetMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        Integer uid = getUidFromSession(session);
        User data = userService.getByUid(uid);
        return new JsonResult<>(OK, data);
    }

    /**
     * @param user user
     * @param session session that contains user information
     * @return JsonResult that contains status of success for updating information
     */
    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(OK);
    }

    /** set maximum constrain for size of avatar to 10MB */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

    /** set the type of avatar */
    public static final List<String> AVATAR_TYPES = new ArrayList<>();
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }

    /**
     * @param file uploaded file for avatar
     * @param session session that contains user information
     * @return JsonResult that contains avatar and the status of success for change avatar
     */
    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {
        // check if the file is empty
        if (file.isEmpty()) {
            throw new FileEmptyException("File cannot be empty.");
        }
        // check if the file is valid size
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("Size cannot exceed " + (AVATAR_MAX_SIZE / 1024) + "KB.");
        }
        // check if the file is valid type
        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)) {
            throw new FileTypeException("Not supported type, please upload " + AVATAR_TYPES);
        }
        // read the avatar path and upload it
        String parent = session.getServletContext().getRealPath("upload");
        System.out.println(parent);
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString() + suffix;
        // create a new file to save avatar
        File dest = new File(dir, filename);
        try {
            file.transferTo(dest); // provided by MultipartFile,write file into destination
        } catch (IllegalStateException e) {
            throw new FileStateException("Unable to access the file.");
        } catch (IOException e) {
            throw new FileUploadIOException("Unable to upload the file.");
        }
        // path of avatar
        String avatar = "/upload/" + filename;
        // get username and user id
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // save the avatar to database
        userService.changeAvatar(uid, username, avatar);
        return new JsonResult<>(OK, avatar);
    }
}

