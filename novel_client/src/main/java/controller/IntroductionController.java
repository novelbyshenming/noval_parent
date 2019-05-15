package controller;

import MyException.IntroductionException;
import bean.IntroductionNovel;
import bean.ReadNovel;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.IntroductionService;
import thrift.IDL.NovelChapter;
import thrift.IDL.NovelChapterContext;
import thrift.IDL.NovelService;
import thrift.client.JavaClientByThrift;

import java.io.UnsupportedEncodingException;

/**
 * @author LX
 * @date 2019/5/12 - 19:03
 */
@Controller
public class IntroductionController {

    @Autowired
    private IntroductionService introductionService;

    @ResponseBody
    @RequestMapping(value = "/novelChapters.n",produces = "text/html; charset=utf-8")
    public String getNovelChapterList(@RequestParam("nid") long nid){

        IntroductionNovel introductionNovel = null;

        try {
            introductionNovel = introductionService.selNovelByNid(nid);

            String novelUrl = introductionNovel.getUrl();

            String novelChaptersJson = new JavaClientByThrift().pyThriftClient(novelUrl);

            return novelChaptersJson;
        } catch (IntroductionException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
            return "网络繁忙";
        }
    }

    @ResponseBody
    @RequestMapping("/introduction.n")
    public IntroductionNovel getIntroductionNovel(@RequestParam("nid") long nid){

        IntroductionNovel introductionNovel = null;
        try {
            introductionNovel = introductionService.selNovelByNid(nid);
        } catch (IntroductionException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return introductionNovel;
    }

    @ResponseBody
    @RequestMapping("/readNovelChapter.n")
    public ReadNovel getNovelChapterContext(@RequestParam("nid") long nid,@RequestParam("cid") long cid){

        IntroductionNovel introductionNovel = null;

        ReadNovel readNovel = null;
        try {
            introductionNovel = introductionService.selNovelByNid(nid);

            String novelChapterUrl = introductionNovel.getUrl()+cid+".html";

            readNovel = getNovelChapterContext(novelChapterUrl);

        } catch (IntroductionException e) {

            System.out.println(e.getMessage());

            e.printStackTrace();
        }
        return readNovel;
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
