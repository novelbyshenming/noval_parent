package service.impl;

import com.yc.bean.ReadNovel;
import com.yc.thrift.client.OrdinaryUserThriftClient;
import mapper.NovelMapper;
import mapper.OrdinaryNovelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.OrdinaryNovelService;

import java.util.HashMap;

/**
 * @author LX
 * @date 2019/5/17 - 19:40
 */
@Service
public class OrdinaryNovelServiceImpl implements OrdinaryNovelService {

    public static HashMap<String,OrdinaryUserThriftClient>
            ordinaryUserThriftClientHashMap = new HashMap<>();

    @Autowired
    private OrdinaryNovelMapper ordinaryNovelMapper;

    @Autowired
    private NovelMapper novelMapper;

    /**
     * 普通用户 访问 小说章节信息
     * @param nid
     * @param cid
     * @param uid
     * @return
     */
    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid, String uid) {
        return null;
    }

    /**
     *  普通用户登陆   获得小说介绍页面的章节信息
     * @param nid
     * @param uid
     * @return
     */
    @Override
    public String getIntroductionNovelChapters(long nid, String uid) {
        return null;
    }
}
