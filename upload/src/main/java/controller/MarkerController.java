package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.Collect;
import service.MarkerService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class MarkerController {
	@Autowired
	private MarkerService markerservice;
	
	@RequestMapping(value="addMarker.u")
	@ResponseBody
	public String addMarker(Collect collect,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		response.setHeader("Access-Control-Allow-Origin", "*");
		System.out.println(collect.getChapName());
		System.out.println(collect.getNid());
		System.out.println(collect.getCid());
		System.out.println(collect.getUid());
		String result = "";
		try{
			List<Collect> marlist = markerservice.selectMarker(collect.getUid());
			if(marlist.size() >=0 && marlist.size() < 21){
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
			if(collect.getUid() == 0) {
				return result+="-2";
			}
			List<Collect> marlist = markerservice.selectMarker(collect.getUid());
			if(marlist.size() < 21){
				markerservice.joinMarker(collect);
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
