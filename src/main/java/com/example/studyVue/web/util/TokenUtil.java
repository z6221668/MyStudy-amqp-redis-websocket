package com.example.studyVue.web.util;

import cn.hutool.crypto.digest.DigestUtil;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;
import java.util.UUID;

/**
 * @author: z6~
 * @time: 2019-10-16 10:21
 */
public class TokenUtil {

    private final static String key = "qieK4cua9YHNs98mztRin";

    /**
     * 加密
     */
    public static String encrypt(String body) {
        return Jwts.builder().setSubject(body)
                .compressWith(CompressionCodecs.DEFLATE)
                .signWith(SignatureAlgorithm.HS512, key).compact();
    }

    /**
     * 解密
     */
    public static String decrypt(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * 生成token
     */
    public static String createToken() {
        String uuid = UUID.randomUUID().toString();
        return DigestUtil.md5Hex(uuid);
    }
}
