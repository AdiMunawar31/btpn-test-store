package com.d2y.btpnteststore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long itemId;
    private Boolean isAvailable;
    private String itemName;
    private String itemCode;
    private LocalDateTime lastReStock;
    private BigDecimal price;
    private Double stock;
}
