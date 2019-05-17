package controller;

import com.yc.bean.ReadNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.VipNovelService;

/**
 * @author LX
 * @date 2019/5/16 - 20:49
 */
@Controller
public class VipNovelController {
    
    @Autowired
    private VipNovelService vipNovelService;

    @ResponseBody
    @RequestMapping(value = "/vipNovelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid,@RequestParam("vid") String vid){

        return vipNovelService.getIntroductionNovelChapters(nid, vid);
    }

    @ResponseBody
    @RequestMapping("/vipReadNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,
                                            @RequestParam("cid") long cid, @RequestParam("vid") String vid){

        return vipNovelService.getNovelChapterContext(nid, cid, vid);
    }
}
