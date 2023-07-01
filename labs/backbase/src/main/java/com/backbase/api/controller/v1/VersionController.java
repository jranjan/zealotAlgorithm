package com.backbase.api.controller.v1;

import com.backbase.api.common.BackbaseFrozenData;
import com.backbase.api.controller.v1.response.error.ApiResponseError;
import com.backbase.api.controller.v1.response.version.VersionInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Version", description = "Provides supported API version")
@RestController
@RequestMapping(value = {"/", "/version"})
public class VersionController {
    @Operation(summary = "Get version information")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = VersionInfo.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(method= RequestMethod.GET)
    public VersionInfo getVersion() {
        VersionInfo response = new VersionInfo();
        response.setVersion(BackbaseFrozenData.VERSION);
        return response;
    }
}
