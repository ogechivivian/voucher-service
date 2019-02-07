package com.voucherz.voucherservice.api.config;

import com.lambdaworks.redis.*;

import org.springframework.beans.factory.annotation.Autowired;

public class RedisService {

    private RedisClient redisClient;

    @Autowired
    public void setRedisClient(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    public String ping() {

        RedisConnection<String, String> connection = redisClient.connect();
        String result = connection.ping();
        connection.close();
        return result;
    }

    public RedisConnection connect(){
        RedisConnection<String,String> connection = redisClient.connect();

        //userid as key
        // serialize data as value
        //{userid : 2,
        // activity : {
        //  action : generate / / login / logout
        //  },
        // timestamp
        // }
        connection.set("userkey","serialized data");
        return connection;
    }
}
