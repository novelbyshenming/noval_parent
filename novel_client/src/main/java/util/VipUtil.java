package util;

import com.yc.thrift.client.VipUserThriftClient;
import org.apache.thrift.transport.TTransportException;

import java.util.HashMap;

/**
 * @author LX
 * @date 2019/5/21 - 15:40
 */
public class VipUtil {

    public static HashMap<String,VipUserThriftClient> vipUserThriftClientHashMap = new HashMap<>();

    static {

        try {
            vipUserThriftClientHashMap.put("1", new VipUserThriftClient());

        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
