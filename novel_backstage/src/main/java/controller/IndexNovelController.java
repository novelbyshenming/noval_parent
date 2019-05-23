package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bean.IndexNovel;
import bean.Msg;
import service.IndexNovelService;

/**
 * @author LX
 * @date 2019/5/12 - 14:17
 */
@Controller  
@RequestMapping("/indexnovel")
public class IndexNovelController {
	@Autowired  
    private IndexNovelService indexNovelService;  
    /**  
     * 获取所有小说列表  
     */  
    @RequestMapping("/getIndexnovel")  
    public String getAllIndexNovel(HttpServletRequest request,Model model){  
        List<IndexNovel> indexnovel = indexNovelService.findAll();  
        model.addAttribute("indexnovelList", indexnovel);  
        request.setAttribute("indexnovelList", indexnovel);  
        return "/indexNovel";  
    } 
    @RequestMapping("/getHomepage")  
    public String getHomepage(HttpServletRequest request,Model model){  
        List<IndexNovel> indexnovel = indexNovelService.findAll();  
        model.addAttribute("indexnovelList", indexnovel);  
        request.setAttribute("indexnovelList", indexnovel);  
        return "/homePage";  
    }  
   /* *//**  
     * 跳转到添加小说界面   
     *//*  
    @RequestMapping("/toAddIndexNovel")  
    public String toAddIndexNovel(){  
        return "/addIndexNovel";  
    }  
    *//**  
     * 添加用户并重定向  
     *//*  
    @RequestMapping("/addIndexNovel")  
    public String addUser(IndexNovel indexnovel,Model model){  
    	indexNovelService.insert(indexnovel);  
        return "redirect:/indexnovel/getAllIndexNovel";  
    }  
    *//**  
     *编辑小说   
     *//*  
    @RequestMapping("/updateIndexNovel")  
    public String updateIndexNovel(IndexNovel indexnovel,HttpServletRequest request,Model model){  
        if(indexNovelService.update(indexnovel)){  
        	indexnovel = indexNovelService.findById(indexnovel.getId());  
            request.setAttribute("indexnovel", indexnovel);  
            model.addAttribute("indexnovel", indexnovel);  
            return "redirect:/indexnovel/getAllIndexNovel";  
        }else{  
            return "/error";  
        }  
    }  
    *//**  
     * 根据id查询单个小说  
     *//*  
    @RequestMapping("/getIndexNovel")  
    public String getIndexNovel(int id,HttpServletRequest request,Model model){  
        request.setAttribute("indexnovel", indexNovelService.findById(id));  
        model.addAttribute("indexnovel", indexNovelService.findById(id));  
        return "";  
    } */ 
    /**  
     * 删除小说  
     */  
    @ResponseBody
    @RequestMapping(value="/delindexnovel", method=RequestMethod.DELETE)
    public Msg delete(@PathVariable("id")Integer id) {
        //Integer id = Integer.parseInt(id);
    	indexNovelService.delete(id);
        return Msg.success();
    }
}  

