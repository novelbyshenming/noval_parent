package mapper;

import bean.User;

/**
 * @author LX
 * @date 2019/5/1 - 18:22
 */
public interface UserMapper {

    int updUser(User user);

//    int insUser(User user);
    User logincheck(User user);
    
    void register(User user);
}
