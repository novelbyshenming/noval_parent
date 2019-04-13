package service.impl;

import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

/**
 * @author LX
 * @date 2019/4/13 - 17:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User selForLogin(User user) {
        
        return userMapper.selForLogin(user);
    }
}
