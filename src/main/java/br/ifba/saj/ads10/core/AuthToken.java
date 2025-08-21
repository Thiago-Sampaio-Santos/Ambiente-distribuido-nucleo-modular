package br.ifba.saj.ads10.core;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Instant;
import java.util.Date;

public class AuthToken {
    private final Algorithm alg;
    public AuthToken(String secret) {
        this.alg = Algorithm.HMAC256(secret);
    }
    public String issue(String subject, long ttlSeconds) {
        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withExpiresAt(Date.from(Instant.now().plusSeconds(ttlSeconds)))
                .sign(alg);
    }
    public boolean valide(String token) {
        try {
            DecodedJWT jwt = JWT.require(alg).build().verify(token);
            return jwt.getExpiresAt().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
