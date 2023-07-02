package com.backbase.api.controller.v1.request.transaction;

import com.backbase.api.common.data.entity.PaymentInfo;
import com.backbase.api.controller.v1.request.BackbaseApiInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionInput extends BackbaseApiInput {
    private String remark;
    private PaymentInfo paymentInfo;
}
