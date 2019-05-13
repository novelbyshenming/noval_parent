package controller;

import MyException.IntroductionException;
import bean.IntroductionNovel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IntroductionService;

/**
 * @author LX
 * @date 2019/5/12 - 19:03
 */
@Controller
public class IntroductionController {

    @Autowired
    private IntroductionService introductionService;


    @ResponseBody
    @RequestMapping("/introduction.n")
    public IntroductionNovel getIntroductionNovel(@RequestParam("nid") long nid){

        IntroductionNovel introductionNovel = null;
        try {
            introductionNovel = introductionService.selNovelByNid(nid);
        } catch (IntroductionException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return introductionNovel;
    }
}
