package com.backbase.api.common.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BackbaseGlobalData implements BackbaseData {
    public static final String VERSION = "1.0";
    public static final double MAX_DAILY_TRANSACTION_LIMIT = 10000;
}
