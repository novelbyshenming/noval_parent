package service.impl;


import com.yc.bean.IntroductionNovel;
import com.yc.bean.ReadNovel;
import com.yc.thrift.IDL.NovelChapter;
import com.yc.thrift.IDL.NovelChapterContext;
import com.yc.thrift.IDL.NovelService;
import mapper.NovelMapper;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.VisitorNovelService;

/**
 * @author LX
 * @date 2019/5/12 - 19:19
 */
@Service
public class VisitorNovelServiceImpl implements VisitorNovelService {

    @Autowired
    private VisitorNovelService visitorNovelService;

    @Autowired
    private NovelMapper novelMapper;

    /**
     * 游客访问  获取小说的章节的信息
     * @param nid
     * @param cid
     * @return
     */
    @Override
    public ReadNovel getNovelChapterContext(long nid, long cid) {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelChapterUrl = introductionNovel.getUrl()+cid+".html";

        return getNovelChapterContext(novelChapterUrl);
    }

    /**
     * 游客  获取小说介绍页面的章节信息
     * @param nid
     * @return
     */
    @Override
    public String getIntroductionNovelChapters(long nid) {

        IntroductionNovel introductionNovel = novelMapper.selNovelByNid(nid);

        String novelUrl = introductionNovel.getUrl();

        return getNovelChapters(novelUrl);
    }


    public ReadNovel getNovelChapterContext(String novelChapterUrl){

        ReadNovel readNovel = null;
        TTransport transport = new TSocket("127.0.0.1",8899);

        try {

            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            NovelService.Client client = new NovelService.Client(tProtocol);


            NovelChapterContext novelChapterContext =
                    client.getNovelChapterContextByChapterUrl(novelChapterUrl);

            readNovel= new ReadNovel();

            readNovel.setContext(novelChapterContext.getContext());

            readNovel.setLastChapter(novelChapterContext.getLastChapter());

            readNovel.setNextChapter(novelChapterContext.getNextChapter());

            readNovel.setNovelChapterName(novelChapterContext.getNovelChapterName());

        } catch (TTransportException e) {
            e.printStackTrace();

        } catch (TException e) {
            e.printStackTrace();
        }
        return readNovel;
    }

    public String getNovelChapters(String novelUrl){
        TTransport transport = new TSocket("127.0.0.1",8899);

        try {
            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            NovelService.Client client = new NovelService.Client(tProtocol);

            NovelChapter novelChapterList = client.getNovelChapterListByNovelUrl(novelUrl);

            String novelChaptersJson = novelChapterList.getNovelChapterJson();

            return  novelChaptersJson;
        } catch (TTransportException e) {
            e.printStackTrace();
            return "出错了";

        } catch (TException e) {
            e.printStackTrace();
        }
        return "出错了";
    }

}
