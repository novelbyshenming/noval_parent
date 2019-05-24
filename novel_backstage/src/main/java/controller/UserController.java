package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;

import bean.Msg;
import bean.Novel;
import bean.Page;
import bean.User;
import service.UserService;


/**
 * @author LX
 * @date 2019/5/12 - 14:17
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 获取所有小说列表
	 */
	@RequestMapping("/getUser")
	public String getAllUser(HttpServletRequest request, Model model) {
		List<User> user = userService.findAll();
		model.addAttribute("userList", user);
		request.setAttribute("userList", user);
		return "/user";
	}

	
}
