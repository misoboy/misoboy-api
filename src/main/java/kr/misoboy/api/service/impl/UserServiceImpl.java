package kr.misoboy.api.service.impl;

import kr.misoboy.api.model.UserModel;
import kr.misoboy.api.repository.UserMapper;
import kr.misoboy.api.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public List<UserModel> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public UserModel selectUserDetail(String emplyrId) {
        return userMapper.selectUserDetail(emplyrId);
    }
}
