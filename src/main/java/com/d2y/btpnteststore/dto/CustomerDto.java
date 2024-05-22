package com.d2y.btpnteststore.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String customerCode;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private Boolean isActive;
    private LocalDateTime lastOrderDate;
    private String pic;
}