package thrift.client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.IDL.NovelChapter;
import thrift.IDL.NovelChapterContext;
import thrift.IDL.NovelService;

/**
 * @author LX
 * @date 2019/5/2 - 20:40
 */
public class JavaClientByThrift {


    public static void main(String[] args) {

        String s = new JavaClientByThrift().pyThriftClient("https://www.biqukan.cc/book/45223/");

        System.out.println(s);
    }

    public  String pyThriftClient(String novelUrl) {

        long start = System.currentTimeMillis();

        TTransport transport = new TSocket("127.0.0.1",8899);

        try {

            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            NovelService.Client client = new NovelService.Client(tProtocol);

            NovelChapter novelChapterList = client.getNovelChapterListByNovelUrl(novelUrl);

            /*NovelChapterContext novelChapterContext = client.getNovelChapterContextByChapterUrl("https://www.biqukan.cc/book/45223/26183162.html");
            System.out.println(novelChapterContext.context+"  "+novelChapterContext.lastChapter);*/
          /* System.out.println("context  "+novelChapterContext.getContext());*/

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
