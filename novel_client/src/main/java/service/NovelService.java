package service;

import MyException.IntroductionException;
import com.yc.bean.IntroductionNovel;

/**
 * @author LX
 * @date 2019/5/17 - 19:45
 */
public interface NovelService {
    IntroductionNovel selNovelByNid(long nid) throws IntroductionException;
}
