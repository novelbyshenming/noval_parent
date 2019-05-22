package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
		String result = "";
		try{
			List<Collect> marlist = markerservice.selectMarker(collect.getUid());
			if(marlist.size() >0 && marlist.size() < 21){
				markerservice.addMarker(collect);
				return result+="1";
			}else{
				return result+="2";
			}
		}catch(Exception e){
			e.printStackTrace();
			return result+="-1";
		}
	}
	
	@RequestMapping(value="joinMarker.u",produces = "text/html; charset=utf-8")
	@ResponseBody
	public String joinMarker(Collect collect,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		String result = "";
		try{
			List<Collect> marlist = markerservice.selectMarker(collect.getUid());
			if(marlist.size() < 21){
				markerservice.addMarker(collect);
				return result+="1";
			}else{
				return result+="2";
			}
		}catch(Exception e){
			e.printStackTrace();
			return result+="-1";
		}
	}
}
