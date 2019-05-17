package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	public List<Collect> collect(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		long uid = user.getUid();
		List<Collect> clist = null;
		try {
			clist = collectService.selectByUid(uid);
			return clist;
		} catch (CollectException e){
			e.printStackTrace();
			return clist;
		}
	}
}
