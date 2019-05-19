package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MyException.CollectException;
import bean.Collect;
import bean.User;
import service.CollectService;

@Controller
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value="collect.u",method= RequestMethod.POST)
	@ResponseBody
	public Map<String,Collect> collect(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		User user = (User) request.getSession().getAttribute("user");
		long uid = user.getUid();
		Map<String,Collect> map = null;
		try {
			map = collectService.selectByUid(uid);
			return map;
			
		} catch (CollectException e){
			e.printStackTrace();
			return map;
		}
	}
}
