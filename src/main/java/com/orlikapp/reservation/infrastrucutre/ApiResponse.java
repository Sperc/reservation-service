package com.orlikapp.reservation.infrastrucutre;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@AllArgsConstructor
@Getter
public class ApiResponse<T> {
    @Setter
    private ApiErrorCode status;
    private String message;
    private T data;
    private String traceId;

    public ApiResponse(String message, String traceId) {
        this.message = message;
        this.traceId = traceId;
    }
}
