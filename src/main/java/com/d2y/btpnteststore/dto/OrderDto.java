package com.d2y.btpnteststore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long orderId;
    private Double quantity;
    private BigDecimal totalPrice;
    private String orderCode;
    private LocalDateTime orderDate;
    private Long customerId;
    private Long itemId;
}
