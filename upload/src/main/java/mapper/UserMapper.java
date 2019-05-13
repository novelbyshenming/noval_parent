package mapper;

import bean.User;

/**
 * @author LX
 * @date 2019/5/1 - 18:22
 */
public interface UserMapper {

//    int insUser(User user);
    User loginCheck(User user);

    void register(User user);
    
    User selectByUid(long uid);
    
    User selectByName(String name);
}
