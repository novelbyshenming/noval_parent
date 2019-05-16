package com.yc.thrift.client;

import org.apache.thrift.transport.TTransportException;


/**
 *
 * 游客模式访问
 * @author LX
 * @date 2019/5/14 - 1:49
 */
public class VisitorThriftClient extends UserThriftClient {

    public VisitorThriftClient() throws TTransportException {
        super();
    }
}
