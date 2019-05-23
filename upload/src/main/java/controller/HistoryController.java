package controller;

import javax.servlet.http.HttpServletRequest;

import bean.History;
import bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MyException.BizException;
import service.HistoryService;

/**
 * @author sm
 *
 */
@Controller
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	
	/**
	 * @param request
	 * @param history
	 * @return
	 */
	@RequestMapping("mermory.u")
	@ResponseBody
	public String mermory(HttpServletRequest request) {
		
		if(request.getSession().getAttribute("user") != null) {//判断session_user是否存在
			//存在 用户已登录
			try {
				User user = (bean.User)request.getSession().getAttribute("user");
				long uid = user.getUid();//获取用户uid
				long nid = Long.parseLong(request.getParameter("nid"));//获取小说nid
				History history = historyService.selRecord(uid,nid);
				if(history != null) //不为空  返回章节cid
					return history.getLatestChaptersUrl();
				else //为空 返回-1
					return "-1";
			} catch (BizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//session_user不存在 用户未登录，通过套取uid进入页面
			return "0";
		}
		return "";
		
	}



}
