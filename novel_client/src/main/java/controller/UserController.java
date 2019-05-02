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
public class UserController {

    public UserController() {
        System.out.println(userServiceImpl);
    }

    @Autowired

    private UserService userServiceImpl;

    @RequestMapping("/login")
    public String login(User user){

        User user1 = userServiceImpl.selForLogin(user);

        if(user1 ==null){

            return "redirect:login.jsp";
        }else{
            return "index.jsp";
        }
    }
}