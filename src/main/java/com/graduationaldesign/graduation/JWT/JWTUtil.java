package com.graduationaldesign.graduation.JWT;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.util.StringUtils;

public class JWTUtil {

    public static final String SECRET = "JKKLJOoasdlfj";

    public static final Long EXPIRE = 10 * 60 * 1000L;

    public static String createToken(String number, int type) throws Exception {
        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        // build token
        // param backups {iss:Service, aud:APP} header-payload
        String token = JWT.create().withHeader(map)
                .withClaim("iss", "Service")
                .withClaim("aud", "APP")
                .withClaim("number", null == number ? null : number)
                .withClaim("type", type + "")
                //.withIssuedAt() // sign time
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE)) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature
        return token;
    }

    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            if(jwt==null){
                new RuntimeException("token不存在");
            }
        } catch (Exception e) {
            //token 校验失败, 抛出Token验证非法异常
            e.printStackTrace();
        }
        return jwt.getClaims();
    }

    public static Map<String, Object> getUserId(String token) {
        Map<String, Claim> claims = verifyToken(token);
        Map<String, Object> result = new HashMap<>(2);
        Claim numberClaim = claims.get("number");
        Claim typeClaim = claims.get("type");
        if (null == numberClaim || StringUtils.isEmpty(numberClaim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
            throw new RuntimeException("Token验证非法");
        }
        if (null == typeClaim || StringUtils.isEmpty(typeClaim.asString())) {
            // token 校验失败, 抛出Token验证非法异常
            throw new RuntimeException("Token不完整");
        }
        result.put("number", numberClaim.asString());
        result.put("type", Integer.valueOf(typeClaim.asString()));
        return result;
    }

}