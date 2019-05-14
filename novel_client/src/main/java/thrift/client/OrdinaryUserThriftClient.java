package thrift.client;

import bean.ReadNovel;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.IDL.NovelChapterContext;
import thrift.IDL.NovelService;

/**
 *            普通用户
 * 用户一登录  就为用户创建  后台  客户端 连接  python服务器
 * @author LX
 * @date 2019/5/14 - 0:40
 */
public class OrdinaryUserThriftClient extends UserThriftClient {

    private ReadNovel nextReadNovel;


    public OrdinaryUserThriftClient() throws TTransportException {
    }
}
