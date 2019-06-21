package com.orlikapp.reservation.infrastrucutre;

import com.orlikapp.reservation.application.base.DataException;
import com.orlikapp.reservation.application.reservation.dto.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SessionUtil {
    public UserId getLoggedUser() {
        return getLoggedClient()
                .map(UserId::of)
                .orElseThrow(() -> new DataException(ApiErrorCode.BAD_TOKEN, "Invalid token", HttpStatus.BAD_REQUEST));
    }

    private Optional<String> getLoggedClient() {

        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        String principal = (String) authentication.getPrincipal();
        return Optional.ofNullable(principal);
    }
}
