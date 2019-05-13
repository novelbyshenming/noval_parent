package service;

import MyException.IntroductionException;
import bean.IntroductionNovel;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
public interface IntroductionService {

    IntroductionNovel selNovelByNid(long nid) throws IntroductionException;
}
