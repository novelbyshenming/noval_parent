package controller;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import bean.User;
import bean.Vip;
import redis.clients.jedis.Jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.util.RedisPoolUtil;

import MyException.UserException;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	//登录验证

	@RequestMapping(value="login.u",method = RequestMethod.POST)
	@ResponseBody
	public String login(User user,HttpServletRequest request) throws UserException, Exception{
		String result="";
		System.out.println(user);
		 Jedis jedis = new Jedis("47.106.110.16",6379);
	        jedis.auth("li157922018");
		if(userService.loginCheck(user) != null){//登录成功
			System.out.println(userService.loginCheck(user));
			Long uid = userService.selectUid(user.getName());//获得uid
			Vip vip = userService.selectVip(uid);//得到vip
			Long nowTimes = System.currentTimeMillis();//获取当前时间
			
			if(vip != null){
				if(vip.getFlag() == 1){//判断该用户是否为vip
					if(nowTimes > vip.getEndTimes()){//判断该用户vip是否过期
						userService.updateVip(uid);//过期则修改数据库
						jedis.set("user:"+uid, uid+"");
					}else{
						//没有过期
						jedis.set("vip:"+uid, uid+"");
						result += "uid="+uid+"&vip=true";
					}
				}else{
					jedis.set("user:"+uid, uid+"");
					result += "uid="+uid;
				}
			}else{
				jedis.set("user:"+uid, uid+"");
				result += "uid="+uid;
			}
		}else{
			System.out.println(userService.loginCheck(user));
			result += "-1";
		}
		jedis.close();
		return result;
	}
	
	
	//注册
	@RequestMapping(value="register.u",method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> register(@Param("user") User user,HttpServletRequest request,HttpServletResponse response) throws UserException{
		HashMap<String,Object> map = new HashMap<String,Object>();//创建一个hashmap存储数据
		String msg = "注册成功";//默认msg为注册成功
		Vip vip = new Vip();
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
			Long uid = userService.selectUid(user.getName());
				Long startTimes = System.currentTimeMillis();
				Long endTimes = startTimes + 30*24*60*60*1000l;
				int flag = 1;
				vip.setStartTimes(startTimes);
				vip.setEndTimes(endTimes);
				vip.setFlag(flag);
				vip.setUid(uid);
			userService.addVip(vip);//新增vip
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
