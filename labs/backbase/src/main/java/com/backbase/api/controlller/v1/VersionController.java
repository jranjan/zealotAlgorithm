package com.backbase.api.controlller.v1;

import com.backbase.api.common.BackbaseFrozenData;
import com.backbase.api.controlller.v1.response.version.Version;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/", "/version"})
public class VersionController {
    @GetMapping()
    public Version getVersion() {
        Version response = new Version();
        response.setVersion(BackbaseFrozenData.VERSION);
        return response;
    }
}
