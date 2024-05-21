package com.d2y.btpnteststore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    private Double quantity;
    private BigDecimal total_price;
    private String order_code;
    private LocalDateTime order_date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer_code;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item_code;

}
