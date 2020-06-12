package com.cloudclass.course.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 类JwtUtils的功能描述:
 * jwt工具类
 * @auther ss
 * @date 2020-6-12
 */
@Component
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String secret;
    private long expire = 60*60*1000;
    private String header;


/*    public JwtUtils(String secret, long expire, String header) {
        this.secret = secret;
        this.expire = expire;
        this.header = header;
    }*/

    /**
     * 生成jwt token
     */
    public String generateToken(String phone) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime()+expire);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(phone)//主题
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)//添加Token过期时间
                //.setAudience(audience) //个人签名
                //.setIssuer(issuer) //发送
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            logger.debug("token验证错误,请重新登陆 ", e);
            return null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public long getExpire() {
        return expire;
    }

    public String getHeader() {
        return header;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public void setHeader(String header) {
        this.header = header;
    }

}
