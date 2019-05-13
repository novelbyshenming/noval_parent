package controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
			request.getSession().setAttribute("user", user);
			return user.getUid()+"";
		}else{
			return "-1";
		}
	}
	
	
	//注册
	@RequestMapping(value="register.u",method = RequestMethod.POST)
	@ResponseBody
	public String register(User user,HttpServletRequest request,HttpServletResponse response) throws UserException{
		String msg = "注册成功";
		try{
		if(user.getName() == null || user.getName() == ""){
			throw new UserException("用户名不能为空!!!");
		}
		if(user.getPwd() == null || user.getPwd() == ""){
			throw new UserException("密码不能为空!!!");
		}
		if(userService.selectByName(user.getName()) != null){
			throw new UserException("用户名已存在!!!");
		}
		
		
			//注册成功
			userService.register(user);
			user.setPwd("");
			request.setAttribute("msg", msg);
			request.setAttribute("user", user);
			return "1";
		}catch(Exception e){
			//注册失败
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			return "-1";
		}
	}
	
}
