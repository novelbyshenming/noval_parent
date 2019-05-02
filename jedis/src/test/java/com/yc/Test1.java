package com.yc;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author LX
 * @date 2019/4/21 - 21:49
 */
public class Test1 {

    @Test
    public void testInsert(){

        Jedis jedis = new Jedis("47.106.110.16",6379);

        String set = jedis.set("address", "寝室1");

        System.out.println(set);

    }
}
