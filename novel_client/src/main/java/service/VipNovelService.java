package service;

import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/17 - 19:42
 */
public interface VipNovelService {

    ReadNovel getNovelChapterContext(long nid , long cid , String vid);

    String getIntroductionNovelChapters(long nid ,String vid);
}
