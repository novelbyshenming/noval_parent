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

    public String pyThriftClient() {

        long start = System.currentTimeMillis();

        TTransport transport = new TSocket("139.199.69.234",8899);

        try {

            transport.open();

            TProtocol tProtocol = new TBinaryProtocol(transport);

            NovelService.Client client = new NovelService.Client(tProtocol);




            NovelChapter novelChapterList = client.getNovelChapterListByNovelUrl("https://www.biqukan.cc/book/45223/");

            System.out.println(novelChapterList.getNovelChapterJson());

            NovelChapterContext novelChapterContext = client.getNovelChapterContextByChapterUrl("https://www.biqukan.cc/book/45223/26183162.html");

           /* System.out.println(novelChapterContext.getContext());

            System.out.println(System.currentTimeMillis()-start);*/
           return  novelChapterContext.context;

        } catch (TTransportException e) {
            e.printStackTrace();

        } catch (TException e) {
            e.printStackTrace();
        }
        return "出错了";
    }
}
