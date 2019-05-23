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
import service.NovelService;

/**
 * @author LX
 * @date 2019/5/12 - 14:17
 */
@Controller
@RequestMapping("/novel")
public class NovelController {
	@Autowired
	private NovelService NovelService;

	/**
	 * 获取所有小说列表
	 */
	@RequestMapping("/getNovel")
	public String getAllNovel(HttpServletRequest request, Model model) {
		List<Novel> novel = NovelService.findAll();
		model.addAttribute("novelList", novel);
		request.setAttribute("novelList", novel);
		return "/Novel";
	}

	/**
	 * 搜索
	 */
	@RequestMapping("/findByName")
	public String findByName(@RequestParam(defaultValue="1") Integer currentPage,HttpServletRequest request,Map<String,Object> map) {
			String novelname=request.getParameter("search");
			PageHelper.startPage(currentPage,8);
			List<Novel> list=NovelService.findByName(novelname);
			Page<Novel> page=new Page<Novel>(list,8);
			map.put("page", page);
			return "/Novel";
	}

	/**
	 * 跳转到添加小说界面
	 */
	/*
	 * @RequestMapping("/toAddIndexNovel") public String toAddIndexNovel(){
	 * return "/addIndexNovel"; }
	 *//**
		 * 添加用户并重定向
		 */
	/*
	 * @RequestMapping("/addIndexNovel") public String addUser(IndexNovel
	 * indexnovel,Model model){ indexNovelService.insert(indexnovel); return
	 * "redirect:/indexnovel/getAllIndexNovel"; }
	 *//**
		 * 编辑小说
		 */
	/*
	 * @RequestMapping("/updateIndexNovel") public String
	 * updateIndexNovel(IndexNovel indexnovel,HttpServletRequest request,Model
	 * model){ if(indexNovelService.update(indexnovel)){ indexnovel =
	 * indexNovelService.findById(indexnovel.getId());
	 * request.setAttribute("indexnovel", indexnovel);
	 * model.addAttribute("indexnovel", indexnovel); return
	 * "redirect:/indexnovel/getAllIndexNovel"; }else{ return "/error"; } }
	 *//**
		 * 根据id查询单个小说
		 */
	/*
	 * @RequestMapping("/getIndexNovel") public String getIndexNovel(int
	 * id,HttpServletRequest request,Model model){
	 * request.setAttribute("indexnovel", indexNovelService.findById(id));
	 * model.addAttribute("indexnovel", indexNovelService.findById(id)); return
	 * ""; }
	 *//**
		 * 删除小说
		 *//*
		 * @ResponseBody
		 * 
		 * @RequestMapping(value="/delindexnovel/{id}",
		 * method=RequestMethod.DELETE) public Msg
		 * delete(@PathVariable("id")Integer id) { //Integer id =
		 * Integer.parseInt(id); indexNovelService.delete(id); return
		 * Msg.success(); }
		 */
}
