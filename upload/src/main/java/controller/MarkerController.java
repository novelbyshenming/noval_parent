package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public String addMarker(Collect collect,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		String ctimes = df.format(new Date());
		User user = (User) request.getSession().getAttribute("user");
		Long uid = user.getUid();
		collect.setUid(uid);
		collect.setCtime(ctimes);
		String msg = "恭喜您，该章节已经加入到您的书签，您可以关闭本窗口！";
		try{
			List<Collect> marlist = markerservice.selectMarker(user.getUid());
			if(marlist.size() < 21){
				markerservice.addMarker(collect);
				return msg;
			}else{
				return "对不起，您的书架已满！（限 20 本）";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败";
		}
	}
	
	@RequestMapping(value="joinMarker.u",produces = "text/html; charset=utf-8")
	@ResponseBody
	public String joinMarker(Collect collect,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println("joinMarker.u   ");
		SimpleDateFormat df = new SimpleDateFormat("MM-dd");
		String ctimes = df.format(new Date());
		/*User user = (User) request.getSession().getAttribute("user");*/
		/*System.out.println(user);*/
		/*if(user != null){*/
			/*Long uid = user.getUid();
			collect.setUid(uid);*/
			collect.setCtime(ctimes);
		
		String msg = "恭喜您，该章节已经加入到您的书签，您可以关闭本窗口！";
		try{
			List<Collect> marlist = markerservice.selectMarker(user.getUid());
			if(marlist.size() < 21){
				markerservice.addMarker(collect);
				return msg;
			}else{
				return "对不起，您的书架已满！（限 20 本）";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "添加失败";
		}
	}
}
