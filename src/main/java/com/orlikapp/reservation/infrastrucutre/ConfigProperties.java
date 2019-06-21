package com.orlikapp.reservation.infrastrucutre;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConfigProperties {
    @Value("${data-management.url}")
    private String dataManagementUrl;
}
