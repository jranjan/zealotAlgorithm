package com.backbase.api.models.v1.version;

import com.backbase.api.common.BackbaseData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Version implements BackbaseData {
    private String version = "1.0";
}
