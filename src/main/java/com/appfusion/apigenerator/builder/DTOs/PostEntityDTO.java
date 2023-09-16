package com.appfusion.apigenerator.builder.DTOs;

import java.time.Instant;
import java.time.LocalDateTime;

public record PostEntityDTO(
    String name,
    int age,
    String email,
    double salary,
    boolean children,
    LocalDateTime eventDateTime,
    Instant time
) {
    
}
