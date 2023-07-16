package com.example.shoppingmallproject.payment.dto;

import com.example.shoppingmallproject.orderPayDelivery.entity.OrderPayDelivery;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PaymentsResultDto {
    private Long id;
    private Long totalPrice;
    private String payMethod;
    private Long payNumber;
    private List<OrderPayDelivery> orderPayDelivery;

    @Builder
    public PaymentsResultDto(Long id, Long totalPrice, String payMethod, Long payNumber, List<OrderPayDelivery> orderPayDelivery) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.payMethod = payMethod;
        this.payNumber = payNumber;
        this.orderPayDelivery = orderPayDelivery;
    }
}
