package com.backbase.api.controller.v1.response.version;

import com.backbase.api.common.data.BackbaseData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VersionInfo implements BackbaseData {
    private String version = "1.0";
}
