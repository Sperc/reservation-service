package com.orlikapp.reservation.infrastrucutre.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SecurityConstants {
    @Value("${jwt.expiration}")
    private long expiration;
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.header}")
    private String header;
}
