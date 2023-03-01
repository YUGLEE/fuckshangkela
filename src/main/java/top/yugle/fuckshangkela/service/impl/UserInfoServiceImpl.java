package top.yugle.fuckshangkela.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.yugle.fuckshangkela.entity.UserInfo;
import top.yugle.fuckshangkela.service.UserInfoService;
import top.yugle.fuckshangkela.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;
import top.yugle.fuckshangkela.utils.RequestUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public String hello(Integer code) throws IOException {
        RequestUtil requestUtil =new RequestUtil();

        List<UserInfo> userInfos = userInfoMapper.selectAll();
        Map<Integer,String> map = new HashMap<>(16);
        for (UserInfo userInfo : userInfos) {
            int userId = Math.toIntExact(userInfo.getUserid());
            String resp = requestUtil.helloSKL(userId, code);
            map.put(userId,resp);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
        return map.toString();
    }
}




