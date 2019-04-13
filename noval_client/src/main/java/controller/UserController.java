package controller;

import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

/**
 *
 * 提示：
 * RequestMapping 配置到 类上面  相当于  根
 *
 *
 *
 * @author LX
 * @date 2019/4/13 - 17:06
 */
@Controller
@RequestMapping(value = "/user.s")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping("/login")
    public String login(User user){

        return null;
    }
}
