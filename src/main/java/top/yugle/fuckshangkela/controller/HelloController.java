package top.yugle.fuckshangkela.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yugle.fuckshangkela.service.UserInfoService;

import java.io.IOException;

/**
 * @author YUGLE
 */
@RestController
public class HelloController {
    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/code")
    public String hello(@Param("code") Integer code) throws IOException {
        return userInfoService.hello(code);
    }

    @GetMapping("/add")
    public String add(@Param("userId") Integer userId){
        return userInfoService.addUser(userId);
    }
}
