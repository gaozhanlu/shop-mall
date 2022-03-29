package com.gzl.base.common.util;

import com.gzl.base.common.model.oauth.UserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil implements Serializable {
    @Value("${jwt.secret:}")
    private String secret;

    @Value("${jwt.header:}")
    private String header;

    @Value("${jwt.expiration:}")
    private long expiration;


    /**
     * 获取token中的信息
     * @param token 生成的token
     * @return 信息
     */
    public String getInfoFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    /**
     * 获取token的生成时间
     * @param token 生成的token
     * @return token的生成时间
     */
    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    /**
     * 获取token的过期时间
     * @param token 生成的token
     * @return token的过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    /**
     * 判断token是否过期
     * @param token 生成的token
     * @return true:过期，false:失效
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(Date.from(Instant.now()));
    }

    public <T> T getClaimFromToken(String token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    /**
     * 生成令牌
     * @param userDetails
     * @return
     */
    public String makeToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    /**
     * 真正进行创建token的方法
     * @param claims
     * @param subject
     * @return
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {
        final Date createdDate = Date.from(Instant.now());
        final Date expirationDate = calculateExpirationDate(createdDate);

        return Jwts.builder()
                .setClaims(claims) /* 自定义属性 */
                .setSubject(subject) /* 该JWT所面向的用户 */
                .setIssuedAt(createdDate) /* 设置发放的时间，类型为： Date*/
                .setExpiration(expirationDate) /* 设置过期时间 类型为：Date */
                .signWith(SignatureAlgorithm.HS512, secret) /* jwt签名算法和密钥 */
                .compact(); /* 返回一个URL安全JWT字符串 */
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
        final Date createdDate =  Date.from(Instant.now());
        final Date expirationDate = calculateExpirationDate(createdDate);

        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(expirationDate);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
//        SecurityUser user = (SecurityUser) userDetails;
        final Date created = getIssuedAtDateFromToken(token);
       /* final Date expiration = getExpirationDateFromToken(token);
        如果token存在，且token创建日期 > 最后修改密码的日期 则代表token有效*/
        return (!isTokenExpired(token)
                /*&& !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate())*/
        );
    }

    /**
     * 生成过期时间
     * @param createdDate 当前时间
     * @return 返回到期时间
     */
    private Date calculateExpirationDate(Date createdDate) {
        return Date.from(Instant.ofEpochMilli(createdDate.toInstant().toEpochMilli()+expiration));
    }


}
