package com.yc.thrift.client;

import com.yc.bean.ReadNovel;
import org.apache.thrift.TException;

/**
 * @author LX
 * @date 2019/5/14 - 2:23
 */
public class Test {

    public static void main(String[] args) {

        try {

            VipUserThriftClient vipUserThriftClient = new VipUserThriftClient();


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
                ReadNovel chapterUrl = vipUserThriftClient.getNovelChapterContextByChapterUrl("");
                /**
                 * 进行 下一章节的获取
                 */
                vipUserThriftClient.setNextChapterUrl(chapterUrl.getNextChapter());

                new Thread(vipUserThriftClient).start();

            }else{

                String nowUrl = "";

                String lastChapter = vipUserThriftClient.getNextReadNovel().getLastChapter();

                if(nowUrl.equals(lastChapter)){
                    //  直接转发nextReadNovel

                    // flag = true  代表可以直接 从内部的 nextReadNovel 取数据
                    new Thread(vipUserThriftClient).start();
                }else{
                    // flag = false    vip用户通过  父类的client 方法的获取数据
                    ReadNovel chapterUrl = vipUserThriftClient.getNovelChapterContextByChapterUrl("");
                    /**
                     * 进行 下一章节的获取
                     */
                    vipUserThriftClient.setNextChapterUrl(chapterUrl.getNextChapter());

                    new Thread(vipUserThriftClient).start();
                }
            }

            ReadNovel novelChapterContextByChapterUrl = new VisitorThriftClient().getNovelChapterContextByChapterUrl("");

        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
