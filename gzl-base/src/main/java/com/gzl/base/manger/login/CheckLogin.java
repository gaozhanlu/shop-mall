package com.gzl.base.manger.login;

import com.gzl.common.error.ApiException;
import com.gzl.common.util.gitip.ClientIpUtil;
import com.gzl.common.util.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class CheckLogin {

    @Autowired
    private RedisCache redisCache;
    //多少时间内的访问次数
    private static final int LIMIT_ADDRESS_INTERVAL = 1000 * 60;
    //访问次数
    private static final int LIMIT_ADDRESS_NUMBER = 3;
    //限制时间
    private static final int LIMIT_ADDRESS_RESTRICTIONS = 1000 * 60;

    public String checkIp(ServerHttpRequest request) {
        // 校验IP登录次数
        String address = ClientIpUtil.getClientIP(request);
        if(!identifyingAddress(address)){
            return "访问次数太频繁，请1小时后再试";
        }
        return "";
    }

    private Boolean identifyingAddress(String address) {
        //记录次数
        String key = address +":identifying";
        //锁定时间
        String restrictions = address +":restrictions";
        //如果用户已被锁定，直接返回false
        if(redisCache.getCacheObject(restrictions)!=null){
            return false;
        }
        //如果用户是初次访问，保存到redis中
        if(redisCache.getCacheObject(key)==null){
            redisCache.setCacheObject(key,1,LIMIT_ADDRESS_INTERVAL,TimeUnit.SECONDS);
        }else{
            //获取访问次数
            int num = (int)redisCache.getCacheObject(key);
            if(num >= LIMIT_ADDRESS_NUMBER){
                //访问次数达到设置的最高上限，锁定用户，返回false
                redisCache.setCacheObject(restrictions,address,LIMIT_ADDRESS_RESTRICTIONS,TimeUnit.SECONDS);
                return false;
            }else{
                Long time=redisCache.getExpire(key);
                int times=Integer.parseInt(String.valueOf(time));
                //访问次数+1 修改这个key对应的值
                redisCache.setCacheObject(key,num + 1,times,TimeUnit.SECONDS);
            }
        }
        return true;
    }

}
