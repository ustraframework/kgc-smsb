package kr.co.kgc.smsb.bo.sample.controller;

import com.gsitm.ustra.java.management.bo.controllers.UstraUserController;
import com.gsitm.ustra.java.management.models.UstraUserModel;
import com.gsitm.ustra.java.management.models.vo.UstraUserOneRqVo;
import com.gsitm.ustra.java.management.properties.UstraManagementBoProperties;
import com.gsitm.ustra.java.management.services.UstraUserService;
import kr.co.kgc.smsb.bo.sample.model.UserModel;
import kr.co.kgc.smsb.bo.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sample/user")
public class UserController {

    @Autowired
    private UstraManagementBoProperties managementBoProperties;

    @Autowired
    private UserService userService;

    @PostMapping("/group")
    public List<UserModel> getUsers(@RequestBody UserModel.Criteria criteria) {
        criteria.setMaskPrivateInfo(managementBoProperties.getApp().getIsPersonalInfoSystem());
        return userService.getUsers(criteria);
    }

    @PostMapping("/detail")
    public UserModel getUser(@RequestBody @Valid UstraUserOneRqVo in) {

        UserModel user = userService.getUser(in.getUsrId());
        if (user != null) {
            user.setPwd(null);
        }

        return user;
    }
}
