package com.backbase.api.controlller.v1;

import com.backbase.api.data.response.acl.ApiVersionResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/backbase/v1", "/backbase/v1/version"})
public class VersionController {

    private static final String apiVersion = "2.0";

    @GetMapping()
    public ApiVersionResponseData getVersion() {
        ApiVersionResponseData response = new ApiVersionResponseData();
        response.setVersion("1.0.0");
        return response;
    }
}
