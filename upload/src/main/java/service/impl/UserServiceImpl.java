package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.User;
import mapper.UserMapper;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
	//属性注入
	@Autowired
	private UserMapper usermapper;
	
	public User logincheck(User user) {
		User u = usermapper.loginCheck(user);
		return u;
	}

	public void register(User user) {
		usermapper.register(user);
		
	}

}
