package service;

import java.util.List;

import com.yc.bean.IntroductionNovel;

import MyException.BizException;

/**
 * @author sm
 * @date 2019/5/23 - 23:50
 */
public interface HotRecommendService {

	List<IntroductionNovel> selectHotMonths() throws BizException;
}
