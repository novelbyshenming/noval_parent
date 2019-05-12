package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import MyException.UserException;
import bean.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//登录验证
	@RequestMapping(value="login.u",method = RequestMethod.POST)
	@ResponseBody
	public String login(User user,HttpServletRequest request) throws UserException{
		if(userService.loginCheck(user) != null){
			user.setPwd("");
			request.getSession().setAttribute("user", user);
			return user.getUid()+"";
		}else{
			return "-1";
		}
	}
	
	
	//注册
	@RequestMapping("register.u")
	public String register(@RequestParam("name") String name,
			@RequestParam("pwd") String pwd) throws UserException{
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		userService.register(user);
		if(user.getUid() != 0){
			return "login.u?messge";
		}
		return "register.u";
	}
}
