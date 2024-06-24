package com.j0suetm.instragam.api.providers;

import com.j0suetm.instragam.api.models.db.*;

import io.github.cdimascio.dotenv.*;
import java.util.*;
import javax.crypto.*;
import java.security.*;
import io.jsonwebtoken.*;
import org.slf4j.*;

public class JWTProvider {
  private final Dotenv env = Dotenv.configure().load();
  private final Logger logger = LoggerFactory.getLogger(JWTProvider.class);
  private SecretKey secretKey;

  public JWTProvider() {
    secretKey = Jwts.SIG.HS256.key().build();
  }

  public String signUser(UserDBModel user) {
    return Jwts.builder()
      .setSubject(user.id.toString())
      .setIssuer("instragam-api")
      .setIssuedAt(new Date())
      .claim("role", "user")
      .claim("handle", user.handle)
      .signWith(secretKey, SignatureAlgorithm.HS256)
      .compact();
  }
}
