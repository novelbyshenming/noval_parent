package mapper;

import java.util.List;


import bean.User;

/**
 * @author LX
 * @date 2019/5/12 - 14:18
 */
public interface UserMapper {
	
	List<User> findAll();
	
}
