package service.impl;

import MyException.UploadException;
import bean.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UploadService;

/**
 * @author LX
 * @date 2019/5/1 - 18:19
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private UserMapper userMapper;


    public void  updUser(User user) throws UploadException {

        int i = userMapper.updUser(user);

        if(i == 0){
            throw new UploadException("更新数据库失败");
        }

    }
}
