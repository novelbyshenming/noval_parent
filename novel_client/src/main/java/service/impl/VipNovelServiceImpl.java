package service.impl;

import MyException.IntroductionException;
import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.thrift.client.VipUserThriftClient;
import com.yc.util.RedisPoolUtil;
import mapper.NovelMapper;
import mapper.VipNovelMapper;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import service.VipNovelService;
import util.ThreadPollUtil;
import util.VipUtil;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
@Service
public class VipNovelServiceImpl implements VipNovelService {

    private HashMap<String,VipUserThriftClient> vipUserThriftClientHashMap = VipUtil.vipUserThriftClientHashMap;

    @Autowired
    private VipNovelMapper vipNovelMapper;

    @Autowired
    private NovelMapper novelMapper;

    private ExecutorService executorService = ThreadPollUtil.executorService;

    /**
     * vip用户 获取 小说章节 内容
     * @param nid
     * @param cid
     * @param uid
     * @return
     */
    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) {

        System.out.println(88888888);
        long start = System.currentTimeMillis();

        Jedis jedis = RedisPoolUtil.getJedis();

        ReadNovel readNovel = null ;

        if (jedis.exists("vip:"+uid)){

            //代表  vip用户登陆
            VipUserThriftClient vipUserThriftClient = vipUserThriftClientHashMap.get(uid);

            try {
                IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

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
                    readNovel = vipUserThriftClient.getNovelChapterContextByChapterUrl(nowUrl);
                    /**
                     * 进行 下一章节的获取
                     */
                    vipUserThriftClient.setFlag(false);

                    vipUserThriftClient.setNextChapterUrl(introductionNovel.getUrl()+readNovel.getNextChapter()+".html");

                    executorService.execute(vipUserThriftClient);
                }else{

                    ReadNovel nextReadNovel = vipUserThriftClient.getNextReadNovel();

                    String tNowUrl = vipUserThriftClient.getNowUrl();


                    if(nowUrl.equals(tNowUrl)){

                        // flag = true  代表可以直接 从内部的 nextReadNovel 取数据
                        // 并且重新  获取 下一章节的信息
                        vipUserThriftClient.setFlag(false);
                        readNovel = nextReadNovel;
                        vipUserThriftClient.setNextChapterUrl(introductionNovel.getUrl()+readNovel.getNextChapter()+".html");
                        executorService.execute(vipUserThriftClient);
                    }else{

                        nowUrl = introductionNovel.getUrl()+cid+".html";
                        // flag = false    vip用户通过  父类的client 方法的获取数据
                        readNovel = vipUserThriftClient.getNovelChapterContextByChapterUrl(nowUrl);

                        vipUserThriftClient.setFlag(false);
                        /**
                         * 进行 下一章节的获取
                         */
                        vipUserThriftClient.setNextChapterUrl(introductionNovel.getUrl()+readNovel.getNextChapter()+".html");
                        executorService.execute(vipUserThriftClient);
                    }
                }

            } catch (TException e) {
                e.printStackTrace();
            }

        }else{
            // 用户信息已经过期或者还未登陆  提示用户重新登陆
            return null;
        }
        RedisPoolUtil.close(jedis);
        return readNovel;
    }

    /**
     * vip用户 获取 小说介绍页面的章节列表
     * @param nid
     * @param uid
     * @return
     */
    @Override
    public String getIntroductionNovelChapters(long nid, String uid) {

        long start = System.currentTimeMillis();

        Jedis jedis = RedisPoolUtil.getJedis();

        String novelChapterListJson = null;

         if (jedis.exists("vip:"+uid)){
            //代表  vip用户登陆
            VipUserThriftClient vipUserThriftClient = vipUserThriftClientHashMap.get(uid);
             System.out.println("vip: "+uid);
            try {
                IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

                novelChapterListJson = vipUserThriftClient.getNovelChapterListByNovelUrl(introductionNovel.getUrl());
            } catch (TException e) {

                e.printStackTrace();
            }

        }else{
            // 用户信息已经过期或者还未登陆  提示用户重新登陆
            return null;
        }
        RedisPoolUtil.close(jedis);

        return novelChapterListJson;
    }
}
