package org.example.adventureworks.Security;

import com.fasterxml.jackson.databind.DatabindException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;
@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String secret; // Secret key used for signing the JWT

    @Value("${app.jwt-expiration-time}")
    private String expirationTime; // Expiration time for the JWT in milliseconds

    // Generates a JWT token for the authenticated user
    public String generateToken(Authentication auth) {
        String username = auth.getName(); // Retrieve the username from the authentication object
        Date now = new Date(); // Current date and time
        Date expirationDate = new Date(now.getTime() + Long.parseLong(expirationTime)); // Calculate the expiration date
        // Build and sign the JWT token
        String token = Jwts.builder()
                .setSubject(username) // Set the username as the subject
                .setIssuedAt(now) // Set the issue date
                .setExpiration(expirationDate) // Set the expiration date
                .signWith(getKey()) // Sign the token with the secret key
                .compact();
        return token; // Return the generated token
    }

    // Retrieves the secret key for signing and validating the JWT
    private Key getKey() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret) // Decode the secret key from Base64
        );
    }

    // 🔹 Obtener username desde el token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid JWT: " + e.getMessage());
            return false;
        }
    }
}
