package controller;

import bean.Novel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author LX
 * @date 2019/5/7 - 15:18
 */
@Controller
public class SearchController {


    /**
     * 根据类型  查询小说信息
     * @return
     */
    @RequestMapping("type.s")
    public String searchByType(String type){


        return "";
    }

    /**
     * 根据 用户输入的  关键信息搜索
     * @return
     */
    @RequestMapping("keys.s")
    public String searchByKeys(String keys){



        return "";
    }


   /* *//**
     * 根据用户输入  词  ajax方法传入过来  进行热词的搜索
     * @return
     *//*
    @ResponseBody
    @RequestMapping("hotKeys.s")
    public List<Novel> searchByHotKeys(String hotKeys){

        return null;
    }*/
}
