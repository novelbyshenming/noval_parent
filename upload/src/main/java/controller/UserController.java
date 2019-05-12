package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String login(User user,HttpServletRequest request) throws UserException, Exception{
		request.setCharacterEncoding("UTF-8");

		if(userService.loginCheck(user) != null){
			user.setPwd("");
			
			/*System.out.println(user.getUid());*/
			request.getSession().setAttribute("user", user);
			return user.getUid()+"";
		}else{
			return "-1";
		}
	}
	
	
	//注册
	@RequestMapping(value="register.u",method = RequestMethod.POST)
	@ResponseBody
	public String register(User user,HttpServletRequest request) throws UserException{
		try{
			userService.register(user);
			request.getSession().setAttribute("user", user);
			return "1";
		}catch(Exception e){
			e.printStackTrace();
			return "-1";
		}
	}
}
