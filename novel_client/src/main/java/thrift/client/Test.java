package thrift.client;

import bean.ReadNovel;
import org.apache.thrift.TException;

/**
 * @author LX
 * @date 2019/5/14 - 2:23
 */
public class Test {

    public static void main(String[] args) {

        try {

            ReadNovel novelChapterContextByChapterUrl = new VisitorThriftClient().getNovelChapterContextByChapterUrl("");

        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
