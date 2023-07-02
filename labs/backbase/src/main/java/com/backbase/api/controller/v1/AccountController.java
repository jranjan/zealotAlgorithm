package com.backbase.api.controller.v1;

import com.backbase.api.acl.data.account.BackendAccountNumberPayload;
import com.backbase.api.acl.data.account.BackendAccountPayload;
import com.backbase.api.acl.data.account.BackendCreateAccountPayload;
import com.backbase.api.acl.data.account.BackendUpdateAccountPayload;
import com.backbase.api.acl.request.AclRequest;
import com.backbase.api.api.manager.BasicApiManager;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.backbase.api.acl.request.EnumAclRequestType.*;

@Tag(name = "Account", description = "Manage account(s)")
@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private BasicApiManager apiManager;

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
    @RequestMapping(value="/{account_number}", method=RequestMethod.GET)
    public AccountInfo getAccount(
            @PathVariable("account_number") final int accountNumber) {
        BackendAccountNumberPayload requestData = new BackendAccountNumberPayload();
        requestData.setAccountNumber(accountNumber);
        AclRequest aclRequest = new AclRequest(ACL_REQUEST_GET_ACCOUNT, requestData, apiManager, null);
        try {
            apiManager.getAclManager().process(aclRequest, null);
            BackendAccountPayload payload = (BackendAccountPayload) aclRequest.getResponseData();
            return payload.getAccountInfo();
        } catch (Exception e) {
            // TODO
            // Prepare error message and send to caller. For now, we will log only.
            log.error("RequestFailure");
            return null;
        }
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
        BackendCreateAccountPayload requestData = new BackendCreateAccountPayload();
        requestData.setAccountCreationInput(accountCreationInput);
        AclRequest aclRequest = new AclRequest(ACL_REQUEST_CREATE_ACCOUNT, requestData, apiManager, null);
        try {
            apiManager.getAclManager().process(aclRequest, null);
            BackendAccountPayload payload = (BackendAccountPayload) aclRequest.getResponseData();
            return payload.getAccountInfo();
        } catch (Exception e) {
            // TODO
            // Prepare error message and send to caller. For now, we will log only.
            log.error("RequestFailure");
            return null;
        }
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
        BackendUpdateAccountPayload requestData = new BackendUpdateAccountPayload();
        requestData.setAccountUpdateInput(accountUpdateInput);
        AclRequest aclRequest = new AclRequest(ACL_REQUEST_UPDATE_ACCOUNT, requestData, apiManager, null);
        try {
            apiManager.getAclManager().process(aclRequest, null);
            BackendAccountPayload payload = (BackendAccountPayload) aclRequest.getResponseData();
            return payload.getAccountInfo();
        } catch (Exception e) {
            // TODO
            // Prepare error message and send to caller. For now, we will log only.
            log.error("RequestFailure");
            return null;
        }
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
            @PathVariable("account_number") final int accountNumber) {
        BackendAccountNumberPayload requestData = new BackendAccountNumberPayload();
        requestData.setAccountNumber(accountNumber);
        AclRequest aclRequest = new AclRequest(ACL_REQUEST_DELETE_ACCOUNT, requestData, apiManager, null);
        try {
            apiManager.getAclManager().process(aclRequest, null);
            BackendAccountPayload payload = (BackendAccountPayload) aclRequest.getResponseData();
            return payload.getAccountInfo();
        } catch (Exception e) {
            // TODO
            // Prepare error message and send to caller. For now, we will log only.
            log.error("RequestFailure");
            return null;
        }
    }
}
