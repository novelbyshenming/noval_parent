package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.User;
import mapper.UserMapper;
import service.UserService;




/**
 * @author LX
 * @date 2019/5/12 - 14:18
 */
@Service  
@Transactional  
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {

	
	@Resource  
	private UserMapper umapper;
	 
	/**
	 * 查询全部数据
	 */
	public List<User> findAll() {
		List<User> findAllList = umapper.findAll(); 
		return findAllList;
	}
	

	

	


	
	
}
