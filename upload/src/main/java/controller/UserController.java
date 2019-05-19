package controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MyException.UserException;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//登录验证

	@RequestMapping(value="login.u",method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> login(User user,HttpServletRequest request) throws UserException, Exception{
		String msg = "登录成功";
		HashMap<String,Object> map = new HashMap<String,Object>();//创建一个hashmap存储数据
		try{
			if(userService.loginCheck(user) != null){
			user.setPwd("");//不能讲pwd存入session
			Long uid = userService.selectUid(user.getName());
			map.put("msg", msg);//将登录结果信息压入集request.getSession().setAttribute("user", user);//将user存入session合
			map.put("result", "1");//将登录结果压进map集合
			map.put("name", user.getName());//将用户名压入集合
			map.put("uid",uid);//将用户id压入集合
			}else{
				throw new UserException("用户名或者密码错误");
			}
			return map;
		}catch(Exception e ){
			e.printStackTrace();
			map.put("msg", e.getMessage());
			map.put("result","-1");
			return map;
		}
	}
	
	
	//注册
	@RequestMapping(value="register.u",method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> register(@Param("user") User user,HttpServletRequest request,HttpServletResponse response) throws UserException{
		HashMap<String,Object> map = new HashMap<String,Object>();//创建一个hashmap存储数据
		String msg = "注册成功";//默认msg为注册成功
		try{
		//后台继续判断用户名是否为空
		if(user.getName() == null || user.getName() == ""){
			throw new UserException("用户名不能为空!!!");
		}
		//后台继续判断密码是否为空
		if(user.getPwd() == null || user.getPwd() == ""){
			throw new UserException("密码不能为空!!!");
		}
		//后台调用方法判断数据库中是否存在此用户名
		if(userService.selectByName(user.getName()) != null){
			throw new UserException("用户名已存在!!!");
		}
		//后台调用方法判断数据库中是否存在此邮箱
		if(userService.selectByEmail(user.getEmail()) != null){
			throw new UserException("邮箱已存在!!!");
		}
		map.put("result", "1");//将注册结果压进map集合
		map.put("msg", msg);//将注册结果信息压入集合
		map.put("name", user.getName());//将用户名压入集合
		map.put("uid", user.getUid());//将用户id压入集合
			//注册成功
			userService.register(user);
			user.setPwd("");
			request.getSession().setAttribute("user", user);
			return map;
			
		}catch(Exception e){
			//注册失败
			e.printStackTrace();
			map.put("result", "-1");
			map.put("msg", e.getMessage());
			return map;
		}
	}
	
}
