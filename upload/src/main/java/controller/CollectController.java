package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MyException.CollectException;
import bean.Collect;
import service.CollectService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
public class CollectController {
	@Autowired
	private CollectService collectService;
	
	@RequestMapping(value="search.u",method= RequestMethod.POST)
	@ResponseBody
	public List<Collect> collect(Long uid,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Collect> list = new ArrayList<Collect>();
		try {
			list = collectService.selectByUid(uid);
		} catch (CollectException e) {
			e.printStackTrace();
		}
		for(int i =0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return list;
		
	}
}
