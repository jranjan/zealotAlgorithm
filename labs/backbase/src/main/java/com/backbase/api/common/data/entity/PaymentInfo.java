package com.backbase.api.common.data.entity;

import com.backbase.api.common.data.BackbaseData;
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
