package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Collect;
import bean.User;
import service.MarkerService;

@Controller
public class MarkerController {
	@Autowired
	private MarkerService markerservice;
	
	@RequestMapping(value="addMarker.u")
	@ResponseBody
	public String addMarker(Collect collect,HttpServletRequest request){
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		String ctimes = df.format(new Date());
		User user = (User) request.getSession().getAttribute("user");
		Long uid = user.getUid();
		collect.setUid(uid);
		collect.setCtime(ctimes);
		String msg = "恭喜您，该章节已经加入到您的书签，您可以关闭本窗口！";
		try{
			markerservice.addMarker(collect);
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败";
		}
	}
	
	@RequestMapping(value="joinMarker.u")
	@ResponseBody
	public String joinMarker(Collect collect,HttpServletRequest request){
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		String ctimes = df.format(new Date());
		User user = (User) request.getSession().getAttribute("user");
		Long uid = user.getUid();
		collect.setUid(uid);
		collect.setCtime(ctimes);
		String msg = "恭喜您，该章节已经加入到您的书签，您可以关闭本窗口！";
		try{
			markerservice.addMarker(collect);
			return msg;
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败";
		}
	}
}
