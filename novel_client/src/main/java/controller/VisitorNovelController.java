package controller;

import com.yc.bean.ReadNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.VisitorNovelService;


/**
 * @author LX
 * @date 2019/5/12 - 19:03
 */
@Controller
public class VisitorNovelController {

    @Autowired
    private VisitorNovelService visitorNovelService;

    @ResponseBody
    @RequestMapping("/readNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid, @RequestParam("cid") long cid){

        return visitorNovelService.getNovelChapterContext(nid, cid);
    }

    @ResponseBody
    @RequestMapping(value = "/novelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid){

        return visitorNovelService.getIntroductionNovelChapters(nid);
    }

}
