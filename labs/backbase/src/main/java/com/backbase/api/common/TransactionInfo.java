package com.backbase.api.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionInfo implements BackbaseData {
    private String transactionId;
    private String date;
    private PaymentInfo paymentInfo;
}
