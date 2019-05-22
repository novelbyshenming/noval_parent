package util;

import com.yc.thrift.client.OrdinaryUserThriftClient;
import com.yc.thrift.client.UserThriftClient;
import com.yc.thrift.client.VipUserThriftClient;
import org.apache.thrift.transport.TTransportException;

import java.util.HashMap;

/**
 * @author LX
 * @date 2019/5/21 - 15:40
 */
public class OrdinaryUtil {

    public static HashMap<String,OrdinaryUserThriftClient> ordinaryUserThriftClientHashMap = new HashMap<>();

    static {

        try {
            ordinaryUserThriftClientHashMap.put("1", new OrdinaryUserThriftClient());

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
