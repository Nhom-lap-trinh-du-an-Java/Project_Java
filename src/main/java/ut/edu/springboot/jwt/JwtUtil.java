package ut.edu.springboot.jwt;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

@Component
public class JwtUtil {
    private static final SecretKey secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    private Object role;


    public String generateToken(String username, String role) {
        // Kiểm tra xem role đã có tiền tố "ROLE_" chưa
        String roleWithPrefix = role.startsWith("ROLE_") ? role : "ROLE_" + role;

        return Jwts.builder()
                .setSubject(username)
                .claim("role", roleWithPrefix) // Gán role với tiền tố ROLE_
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // Hết hạn sau 1 giờ
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }



    // Lấy thông tin Claims từ token
    private static Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

    // Lấy username từ token
    public static String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Lấy role từ token
    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    // Kiểm tra token có hợp lệ không
    public static boolean validateToken(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // Kiểm tra token có hết hạn chưa
    private static boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
