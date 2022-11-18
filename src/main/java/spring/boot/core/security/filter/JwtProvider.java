package spring.boot.core.security.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import spring.boot.core.exception.BaseException;
import spring.boot.core.security.userdetail.Authority;
import spring.boot.core.security.userdetail.UserPrincipal;

@Service
public class JwtProvider {

    public JwtProvider(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    private final SecretKey secretKey;

    public Map<String, Object> generateToken(JwtTokenProperties jwtTokenProperties) {
        Long id = jwtTokenProperties.getId();
        String username = jwtTokenProperties.getUsername();
        String fullName = jwtTokenProperties.getFullName();
        String email = jwtTokenProperties.getEmail();
        List<String> privileges = jwtTokenProperties.getPrivileges();
        Map<String, Object> jwtAdditionalInformation = jwtTokenProperties.getJwtAdditionalInformation();
        Map<String, Object> additionalInformation = jwtTokenProperties.getAdditionalInformation();

        if (jwtAdditionalInformation == null) {
            jwtAdditionalInformation = new HashMap<>();
        }

        if (additionalInformation == null) {
            additionalInformation = new HashMap<>();
        }

        if (privileges == null) {
            privileges = new ArrayList<>();
        }

//    if (id != null && id > 0) {
//      privileges.add("ROLE_Authenticated");
//    }
//
//    if (!privileges.contains("ROLE_Unauthenticated")) {
//      privileges.add("ROLE_Unauthenticated");
//    }
        JwtBuilder jwtBuilder = Jwts.builder()
                .claim("userId", id)
                .claim("username", username)
                .claim("email", email)
                .claim("fullname", fullName)
                .claim("authorities", privileges);
        for (String key : jwtAdditionalInformation.keySet()) {
            jwtBuilder.claim(key, jwtAdditionalInformation.get(key));
            additionalInformation.put(key, jwtAdditionalInformation.get(key));
        }

        String jwt = jwtBuilder
                .setIssuedAt(new Date())
                .setExpiration(Date.from(ZonedDateTime.now().plusDays(1).toInstant()))
                .signWith(secretKey)
                .compact();

        UserPrincipal userPrincipal = new UserPrincipal();
        userPrincipal.setId(id);
        userPrincipal.setUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String s : privileges) {
            authorities.add(new Authority(s));
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                userPrincipal,
                null,
                authorities
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        additionalInformation.put("userId", userPrincipal.getId());
        additionalInformation.put("token", jwt);
        additionalInformation.put("email", email);
        additionalInformation.put("username", username);
        additionalInformation.put("avatar", jwtTokenProperties.getAvatar());
        additionalInformation.put("full_name", fullName);
        additionalInformation.put("authorities", privileges);
        additionalInformation.put("role", jwtTokenProperties.getRole());

        return additionalInformation;
    }

    public UserDetails getAuthentication(String token) {
        Claims claims = parseToken(token);

        Long id = Long.valueOf(claims.get("userId").toString());
        String username = (String) claims.get("username");

        String arrayAuthorize = claims.get("authorities").toString();

        Collection authorities =
                Arrays.stream(arrayAuthorize
                                .substring(1, arrayAuthorize.length() - 1).split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        UserPrincipal userDetails = new UserPrincipal();

        userDetails.setId(id);
        userDetails.setUsername(username);
        userDetails.setAuthorities(authorities);
        return userDetails;
    }

    private Claims parseToken(String token) {
        try{
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw new BaseException(401,"Invalid JWT signature: {}");
        } catch (MalformedJwtException e) {
            throw new BaseException(401,"Invalid JWT token: {}");
        } catch (ExpiredJwtException e) {
            throw new BaseException(401,"JWT token đã hết hạn");
        } catch (UnsupportedJwtException e) {
            throw new BaseException(401,"JWT token is unsupported");
        } catch (IllegalArgumentException e) {
            throw new BaseException(401,"JWT claims string is empty");
        }

    }

    @Getter
    @Builder
    public static class JwtTokenProperties {

        private final Long id;

        private final String username;

        private final String fullName;

        private final String role;

        private final String avatar;

        private final String email;

        private final List<String> privileges;

        private final Map<String, Object> additionalInformation;

        private final Map<String, Object> jwtAdditionalInformation;

    }
}