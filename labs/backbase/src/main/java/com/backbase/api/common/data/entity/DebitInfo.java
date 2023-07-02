package com.backbase.api.common.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DebitInfo extends PaymentTypeInfo {
    private String bankName;
    private String branchCode;
    private String purpose;
}
