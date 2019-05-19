package com.yc.thrift.client;

import org.apache.thrift.transport.TTransportException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 *
 * 游客模式访问
 * @author LX
 * @date 2019/5/14 - 1:49
 */
@Scope("prototype")
@Component
public class VisitorThriftClient extends UserThriftClient {

    public VisitorThriftClient() throws TTransportException {
        super();
    }
}
