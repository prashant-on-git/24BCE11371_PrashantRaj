package com.talentbridge.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET =
            "TalentBridgeSecretKeyForJWTAuthentication2026VerySecureKey";

    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date())
        .setExpiration(
        new Date(System.currentTimeMillis() + 3600000)
        )
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
    }
}
