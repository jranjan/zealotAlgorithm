package com.backbase.api.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BranchInfo implements BackbaseData{
    private String bankName;
    private String bankSwiftCode;
    private String bankIfscCode;
    private String bankBranchCode;
}
