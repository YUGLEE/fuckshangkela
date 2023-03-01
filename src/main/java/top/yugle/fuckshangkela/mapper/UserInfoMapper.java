package top.yugle.fuckshangkela.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.yugle.fuckshangkela.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author YUGLE
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2023-03-01 11:07:07
* @Entity top.yugle.fuckshangkela.entity.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> selectAll();
}




