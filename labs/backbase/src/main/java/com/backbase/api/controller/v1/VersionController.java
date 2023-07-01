package com.backbase.api.controller.v1;

import com.backbase.api.common.BackbaseFrozenData;
import com.backbase.api.controller.v1.response.version.Version;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Version", description = "Provides supported API version")
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
