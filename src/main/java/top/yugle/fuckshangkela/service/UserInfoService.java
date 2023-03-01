package top.yugle.fuckshangkela.service;

import top.yugle.fuckshangkela.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;

/**
* @author YUGLE
* @description 针对表【user_info】的数据库操作Service
* @createDate 2023-03-01 11:07:07
*/
public interface UserInfoService extends IService<UserInfo> {

    String addUser(Integer userId);

    String hello(Integer code) throws IOException;
}
