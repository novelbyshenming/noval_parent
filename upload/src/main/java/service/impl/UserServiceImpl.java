package service.impl;

import bean.User;
import bean.Vip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MyException.UserException;
import mapper.UserMapper;
import service.UserService;

@Service
public class UserServiceImpl implements UserService{
	//属性注入
	@Autowired
	private UserMapper usermapper;
	
	public User loginCheck(User user) {
		User u = usermapper.loginCheck(user);
		return u;
	}

	public void register(User user) {
		
		usermapper.register(user);
	}

	@Override
	public User selectByUid(Long uid) throws UserException {
		User user = usermapper.selectByUid(uid);
		return user;
	}

	@Override
	public User selectByName(String name) throws UserException {
		User user = usermapper.selectByName(name);
		return user;
	}

	@Override
	public User selectByEmail(String email) throws UserException {
		User user = usermapper.selectByEmail(email);
		return user;
	}
	
	@Override
	public Long selectUid(String name)throws UserException{
		Long uid = usermapper.selectUid(name);
		return uid;
	}

	@Override
	public Vip selectVip(Long uid) throws UserException {
		Vip  vip= usermapper.selectVip(uid);
		return vip;
	}

	@Override
	public void updateVip(Long uid) throws UserException {
		usermapper.updateVip(uid);
		
	}

	@Override
	public void addVip(Vip vip) throws UserException {
		usermapper.addVip(vip);
		
	}
}
