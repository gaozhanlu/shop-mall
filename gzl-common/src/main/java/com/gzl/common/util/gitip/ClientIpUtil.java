package com.gzl.common.util.gitip;

import org.springframework.http.server.ServerHttpRequest;
import java.net.InetSocketAddress;
import java.util.List;

public class ClientIpUtil {

    public static String getClientIP(ServerHttpRequest request) {
        String ip = "";
        List<String> list = request.getHeaders().get("x-forwarded-for");
        if(list != null && list.size() > 0){
            ip = list.get(0);
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            List<String> list1 = request.getHeaders().get("Proxy-Client-IP");
            if(list1 != null && list1.size() > 0){
                ip = list1.get(0);
            }
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            List<String> list1 = request.getHeaders().get("WL-Proxy-Client-IP");
            if(list1 != null && list1.size() > 0){
                ip = list1.get(0);
            }
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            InetSocketAddress remoteAddress = request.getRemoteAddress();
            ip = remoteAddress.getAddress().getHostAddress();
        }

        return ip;
    }


}
