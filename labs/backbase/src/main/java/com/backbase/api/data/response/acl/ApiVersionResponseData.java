package com.backbase.api.data.response.acl;

import com.backbase.api.data.BackbaseData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiVersionResponseData implements BackbaseData {
    private String version = "1.0";
}
