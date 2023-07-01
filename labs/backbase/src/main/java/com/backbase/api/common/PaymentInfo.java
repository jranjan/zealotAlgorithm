package com.backbase.api.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentInfo implements BackbaseData {
    private double amount;
    private PaymentType paymentType;
    private PaymentTypeInfo paymentTypeInfo;
}
