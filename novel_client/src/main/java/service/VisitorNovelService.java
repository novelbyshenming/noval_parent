package service;


import com.yc.bean.ReadNovel;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
public interface VisitorNovelService {

    String getIntroductionNovelChapters(long nid);

    ReadNovel getNovelChapterContext(long nid , long cid );
}
