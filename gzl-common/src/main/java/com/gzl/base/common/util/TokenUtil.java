//package com.gzl.base.common.util;
//
//import cn.hutool.core.convert.Convert;
//import com.gzl.base.common.model.oauth.AuthInfo;
//import io.jsonwebtoken.Claims;
//
//import java.util.Date;
//
//public class TokenUtil {
//    /**
//     * 创建认证token
//     *
//     * @param userInfo 用户信息
//     * @return token
//     */
//    public AuthInfo createAuthInfo(JwtUserInfo userInfo, Long expireMillis) {
//        if (expireMillis == null || expireMillis <= 0) {
//            expireMillis = jwtProperties.getExpire();
//        }
//
//        //设置jwt参数
//        Map<String, String> param = new HashMap<>(16);
//        param.put(JWT_KEY_TOKEN_TYPE, BEARER_HEADER_KEY);
//        param.put(JWT_KEY_USER_ID, Convert.toStr(userInfo.getUserId(), "0"));
//        param.put(JWT_KEY_ACCOUNT, userInfo.getAccount());
//        param.put(JWT_KEY_NAME, userInfo.getName());
//
//        Token token = JwtUtil.createJwt(param, expireMillis);
//
//        AuthInfo authInfo = new AuthInfo();
//        authInfo.setAccount(userInfo.getAccount());
//        authInfo.setName(userInfo.getName());
//        authInfo.setUserId(userInfo.getUserId());
//        authInfo.setTokenType(BEARER_HEADER_KEY);
//        authInfo.setToken(token.getToken());
//        authInfo.setExpire(token.getExpire());
//        authInfo.setExpiration(token.getExpiration());
//        authInfo.setRefreshToken(createRefreshToken(userInfo).getToken());
//        authInfo.setExpireMillis(expireMillis);
//        return authInfo;
//    }
//
//    /**
//     * 创建refreshToken
//     *
//     * @param userInfo 用户信息
//     * @return refreshToken
//     */
//    private Token createRefreshToken(JwtUserInfo userInfo) {
//        Map<String, String> param = new HashMap<>(16);
//        param.put(JWT_KEY_TOKEN_TYPE, REFRESH_TOKEN_KEY);
//        param.put(JWT_KEY_USER_ID, Convert.toStr(userInfo.getUserId(), "0"));
//        return JwtUtil.createJwt(param, jwtProperties.getRefreshExpire());
//    }
//
//    /**
//     * 解析token
//     *
//     * @param token token
//     * @return 用户信息
//     */
//    public AuthInfo getAuthInfo(String token) {
//        Claims claims = JwtUtil.getClaims(token, jwtProperties.getAllowedClockSkewSeconds());
//        String tokenType = Convert.toStr(claims.get(JWT_KEY_TOKEN_TYPE));
//        Long userId = Convert.toLong(claims.get(JWT_KEY_USER_ID));
//        String account = Convert.toStr(claims.get(JWT_KEY_ACCOUNT));
//        String name = Convert.toStr(claims.get(JWT_KEY_NAME));
//        Date expiration = claims.getExpiration();
//        return new AuthInfo().setToken(token)
//                .setExpire(expiration != null ? expiration.getTime() : 0L)
//                .setTokenType(tokenType).setUserId(userId)
//                .setAccount(account).setName(name);
//    }
//
//    /**
//     * 解析刷新token
//     *
//     * @param token 待解析的token
//     * @return 认证信息
//     */
//    public AuthInfo parseRefreshToken(String token) {
//        Claims claims = JwtUtil.parseJwt(token, jwtProperties.getAllowedClockSkewSeconds());
//        String tokenType = Convert.toStr(claims.get(JWT_KEY_TOKEN_TYPE));
//        Long userId = Convert.toLong(claims.get(JWT_KEY_USER_ID));
//        Date expiration = claims.getExpiration();
//        return new AuthInfo().setToken(token)
//                .setExpire(expiration != null ? expiration.getTime() : 0L)
//                .setTokenType(tokenType).setUserId(userId);
//    }
//}
