package com.yc.thrift.client;

import com.yc.bean.ReadNovel;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *            普通用户
 * 用户一登录  就为用户创建  后台  客户端 连接  python服务器
 * @author LX
 * @date 2019/5/14 - 0:40
 */
@Scope("prototype")
@Component
public class OrdinaryUserThriftClient extends UserThriftClient {

    private ReadNovel nextReadNovel;


    public OrdinaryUserThriftClient() throws TTransportException {
    }
}
