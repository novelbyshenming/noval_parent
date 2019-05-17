package controller;

import MyException.IntroductionException;
import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.thrift.client.VipUserThriftClient;
import com.yc.util.RedisPoolUtil;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import service.IntroductionService;

import java.util.HashMap;

/**
 * @author LX
 * @date 2019/5/16 - 20:49
 */
@Controller
public class VipIntroductionController {
    
    public static HashMap<String,VipUserThriftClient> vipUserThriftClientHashMap = new HashMap<>();

    static {
        /*
        try {
            vipUserThriftClientHashMap.put(1+"", new VipUserThriftClient());

        } catch (TTransportException e) {
            e.printStackTrace();
        }*/
    }

    @Autowired
    private IntroductionService introductionService;

    @ResponseBody
    @RequestMapping(value = "/novelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid,@RequestParam("uid") long uid){

        Jedis jedis = RedisPoolUtil.getJedis();

        String novelChapterList = null;

        if(jedis.exists("ordinary:"+uid)){
            // 代表 普通用户登陆
            return null;
        }else if (jedis.exists("vip:"+uid)){
            //代表  vip用户登陆
            VipUserThriftClient vipUserThriftClient = vipUserThriftClientHashMap.get(uid);

            try {

                IntroductionNovel introductionNovel = introductionService.selNovelByNid(nid);

                novelChapterList = vipUserThriftClient.getNovelChapterListByNovelUrl(introductionNovel.getUrl());

            } catch (TException e) {

                e.printStackTrace();
            } catch (IntroductionException e) {

                e.printStackTrace();
            }

        }else{
            // 用户信息已经过期或者还未登陆  提示用户重新登陆
            return null;
        }

        RedisPoolUtil.close(jedis);

        return novelChapterList ;
    }


    @ResponseBody
    @RequestMapping("/readNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,
                                            @RequestParam("cid") long cid, @RequestParam("uid") long uid){


        Jedis jedis = RedisPoolUtil.getJedis();

        ReadNovel chapterUrl = null ;

        if(jedis.exists("ordinary:"+uid)){
            // 代表 普通用户登陆
            return null;
        }else if (jedis.exists("vip:"+uid)){
            //代表  vip用户登陆
            VipUserThriftClient vipUserThriftClient = vipUserThriftClientHashMap.get(uid);

            try {
                IntroductionNovel introductionNovel = introductionService.selNovelByNid(nid);

                String nowUrl = introductionNovel.getUrl()+cid+".html";
                //    如果用户  看小说 的 时候  突然点击 另外一个 页面
                //    然后按 返回键  页面没有刷新  再点击 下一章
                //     这个时候 我们下一个章节我们是  保存在nextReadNovel 里面
                //     那就在  flag = true 的时候  进行  url的判断
                //      拿 接受到 的 url 和 nextReadNovel 的lastChapter相比较
                //                  相等就直接转发
                //                  不相等 就   进行 父类的client的 数据获取
                /**
                 *   flag 为 true  代表第下一章可以直接拿
                 *
                 *   flag 为 false 代表内部的nextReadNovel还没初始化好
                 *
                 *   得重新进行  普通的client的 数据获取
                 */

                if(! vipUserThriftClient.isFlag()){

                    // flag = false    vip用户通过  父类的client 方法的获取数据
                    chapterUrl = vipUserThriftClient.getNovelChapterContextByChapterUrl(nowUrl);
                    /**
                     * 进行 下一章节的获取
                     */
                    vipUserThriftClient.setNextChapterUrl(chapterUrl.getNextChapter());

                    new Thread(vipUserThriftClient).start();

                }else{

                    String lastChapter = vipUserThriftClient.getNextReadNovel().getLastChapter();

                    nowUrl = cid+"";
                        if(nowUrl.equals(lastChapter)){

                        // flag = true  代表可以直接 从内部的 nextReadNovel 取数据
                        // 并且重新  获取 下一章节的信息
                        new Thread(vipUserThriftClient).start();

                        chapterUrl = vipUserThriftClient.getNextReadNovel();

                        }else{
                        // flag = false    vip用户通过  父类的client 方法的获取数据
                        chapterUrl = vipUserThriftClient.getNovelChapterContextByChapterUrl(nowUrl);

                        vipUserThriftClient.setFlag(false);

                        /**
                         * 进行 下一章节的获取
                         */
                        vipUserThriftClient.setNextChapterUrl(chapterUrl.getNextChapter());

                        new Thread(vipUserThriftClient).start();
                        }
                }

            } catch (IntroductionException e) {

                e.printStackTrace();
            } catch (TException e) {
                e.printStackTrace();
            }

        }else{
            // 用户信息已经过期或者还未登陆  提示用户重新登陆
            return null;
        }

        return chapterUrl;
    }
}
