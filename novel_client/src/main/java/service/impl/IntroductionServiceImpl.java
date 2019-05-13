package service.impl;

import MyException.IntroductionException;
import bean.IntroductionNovel;
import mapper.IntroductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IntroductionService;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
@Service
public class IntroductionServiceImpl implements IntroductionService {

    @Autowired
    private IntroductionMapper introductionMapper;

    public IntroductionNovel selNovelByNid(long nid) throws IntroductionException {

        IntroductionNovel novel = introductionMapper.selNovelByNid(nid);

        if(novel==null){
            throw new IntroductionException("数据库查询错误");
        }
        return novel;
    }
}
