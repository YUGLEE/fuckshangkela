package top.yugle.fuckshangkela.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yugle.fuckshangkela.entity.UserInfo;
import top.yugle.fuckshangkela.service.UserInfoService;
import top.yugle.fuckshangkela.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author YUGLE
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2023-03-01 11:07:07
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{
    private final UserInfoMapper userInfoMapper;

    public UserInfoServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public String addUser(Integer userId) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserid(Long.valueOf(userId));

        int insert = userInfoMapper.insert(userInfo);
        if (insert == 1){
            return "添加成功";
        }
        return "添加失败";
    }
}




