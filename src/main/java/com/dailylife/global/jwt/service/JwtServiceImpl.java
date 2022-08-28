package com.dailylife.global.jwt.service;

import com.dailylife.domain.user.entity.User;
import com.dailylife.domain.user.repository.UserRepository;
import com.dailylife.domain.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j
public class JwtServiceImpl implements JwtService {

    private final UserRepository userRepository;

    private final Long ACCESS_TOKEN_VALID_TIME = 60 * 60 * 2 * 10 * 1000L;

    @Override
    public String createAccessJwt(String UserId) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("type", "jwt")
                .claim("loginId", UserId)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + ACCESS_TOKEN_VALID_TIME))
                .signWith(SignatureAlgorithm.HS256, "dailylife1234!!") //
                .compact();
    }

    @Override
    public String resolveAccessToken() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return request.getHeader("X-ACCESS-TOKEN");
    }

    @Override
    public String getLoginId() {
        String accessToken = resolveAccessToken();
        if (accessToken == null || accessToken.length() == 0)
            throw new RuntimeException("토큰x");

        Jws<Claims> claims;

        try{
            claims = Jwts.parser()
                    .setSigningKey("dailylife1234!!")
                    .parseClaimsJws(accessToken); // 파싱 및 검증, 실패 시 에러
        }catch (Exception e3){
            throw new RuntimeException("토큰x2");
        }

        return claims.getBody().get("loginId",String.class);
    }

    @Override
    public String update(String userLoginId) {
        User user = userRepository.findByUserId(userLoginId);
        return createAccessJwt(user.getUserId());
    }

}
