package com.backbase.api.controller.v1;

import com.backbase.api.controller.v1.request.account.AccountCreationInput;
import com.backbase.api.controller.v1.request.account.AccountUpdateInput;
import com.backbase.api.controller.v1.response.account.AccountInfo;
import com.backbase.api.controller.v1.response.error.ApiResponseError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Account", description = "Manage account(s)")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Operation(summary = "Get account information")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = AccountInfo.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(value="/{account}", method=RequestMethod.GET)
    public AccountInfo getAccount(
            @PathVariable("account") final String account) {
        AccountInfo response = new AccountInfo();
        return response;
    }

    @Operation(summary = "Create a new account")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = AccountInfo.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "409", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(method=RequestMethod.POST)
    public AccountInfo createAccount(@RequestBody AccountCreationInput accountCreationInput) {
        AccountInfo response = new AccountInfo();
        return response;
    }
    @Operation(summary = "Update account information")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = AccountInfo.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(value="/{account_number}", method=RequestMethod.PUT)
    public AccountInfo updateAccount(
            @RequestBody AccountUpdateInput accountUpdateInput) {
        AccountInfo response = new AccountInfo();
        return response;
    }

    @Operation(summary = "Delete the account")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = AccountInfo.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(value="/{account_number}", method=RequestMethod.DELETE)
    public AccountInfo deleteAccount(
            @PathVariable("account_number") final String account_number) {
        AccountInfo response = new AccountInfo();
        return response;
    }
}
