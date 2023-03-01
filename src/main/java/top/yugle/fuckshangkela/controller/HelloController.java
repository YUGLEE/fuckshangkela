package top.yugle.fuckshangkela.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yugle.fuckshangkela.service.UserInfoService;

/**
 * @author YUGLE
 */
@RestController
public class HelloController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/code")
    public String hello(@Param("code") Integer code){
        System.out.println("userInfo = " + code.toString());
        return code.toString();
    }

    @GetMapping("/add")
    public String add(@Param("userId") Integer userId){
        return userInfoService.addUser(userId);
    }
}
