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
	 * 新增小说章节记忆
	 * @param request
	 * @param history
	 * @return
	 */
	@RequestMapping("mermory")
	@ResponseBody
	public String mermory(HttpServletRequest request,History history) {
		try {
			User user = (User)request.getSession().getAttribute("user");
			long uid = user.getUid();//获取用户id
			
			long nid = Long.parseLong(request.getParameter("nid"));//获取小说nid
			String latestChaptersUrl = request.getParameter("cid");//获取小说章节latestChaptersUrl
			history.setUid(uid);
			history.setNid(nid);
			history.setLatestChaptersUrl(latestChaptersUrl);
			
			History novelHistory = historyService.selRecord(nid);//查询该小说章节是否已存在记忆
			if(novelHistory!= null) {
				//不存在，新增该小说章节记忆
				historyService.newRecord(history);
			}else {
				//存在，修改该小说章节记忆至当前点击章节
				historyService.updRecord(history);
			}
		} catch (BizException e) {
			request.setAttribute("errormsg", "系统繁忙，请稍后再试！");
		}
		return "mermory";
	}
}
