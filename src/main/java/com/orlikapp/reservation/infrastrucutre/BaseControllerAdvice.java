package com.orlikapp.reservation.infrastrucutre;

import com.orlikapp.reservation.application.base.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@Slf4j
@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse handleException(HttpMessageNotReadableException ex) {
        final String uuidException = UUID.randomUUID()
                                         .toString();
        log.info("ERROR - " + uuidException + ", message: " + ex.getMessage(), ex);
        return new ApiResponse("Invalid JSON", uuidException);
    }

    @ExceptionHandler(DataException.class)
    @ResponseBody
    public ResponseEntity<ApiResponse> handleException(DataException ex) {
        final String uuidException = UUID.randomUUID()
                                         .toString();
        log.info("ERROR - " + uuidException + ", message: " + ex.getMessage(), ex);
        return new ResponseEntity<>(new ApiResponse<>(ex.getCode(), ex.getMessage(), null, uuidException), ex.getHttpStatus());
    }
}
