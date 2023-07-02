package com.backbase.api.controller.v1;

import com.backbase.api.acl.data.account.BackendAccountNumberPayload;
import com.backbase.api.acl.data.account.BackendAccountPayload;
import com.backbase.api.acl.data.account.BackendCreateAccountPayload;
import com.backbase.api.acl.data.transaction.BackendCreateTransactionPayload;
import com.backbase.api.acl.data.transaction.BackendTransactionPayload;
import com.backbase.api.acl.request.AclRequest;
import com.backbase.api.api.manager.BasicApiManager;
import com.backbase.api.api.manager.IApiManager;
import com.backbase.api.controller.v1.request.transaction.TransactionInput;
import com.backbase.api.controller.v1.response.error.ApiResponseError;
import com.backbase.api.controller.v1.response.transaction.TransactionInfo;
import com.backbase.api.controller.v1.response.transaction.TransactionInfoCollection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.backbase.api.acl.request.EnumAclRequestType.ACL_REQUEST_CREATE_ACCOUNT;
import static com.backbase.api.acl.request.EnumAclRequestType.ACL_REQUEST_DELETE_ACCOUNT;

@Tag(name = "Transaction", description = "Manage transaction(s) associated with given account")
@Slf4j
@RestController
@RequestMapping("/accounts")
public class TransactionController {

    private BasicApiManager apiManager;

    @Operation(summary = "Get account information")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = TransactionInfoCollection.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "404", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(value="/{account_number}/transactions", method= RequestMethod.GET)
    public TransactionInfoCollection getAccountTransaction(
            @PathVariable("account_number") final int accountNumber) {
        BackendAccountNumberPayload requestData = new BackendAccountNumberPayload();
        requestData.setAccountNumber(accountNumber);
        AclRequest aclRequest = new AclRequest(ACL_REQUEST_DELETE_ACCOUNT, requestData, apiManager, null);
        try {
            apiManager.getAclManager().process(aclRequest, null);
            BackendTransactionPayload payload = (BackendTransactionPayload) aclRequest.getResponseData();
            return payload.getTransactionInfoCollection();
        } catch (Exception e) {
            // TODO
            // Prepare error message and send to caller. For now, we will log only.
            log.error("RequestFailure");
            return null;
        }
    }

    @Operation(summary = "Create a transaction")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = TransactionInfo.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiResponseError.class), mediaType = "application/json")
            }),
    })
    @RequestMapping(value="/{account_number}/transactions", method=RequestMethod.POST)
    public TransactionInfo createTransaction(@RequestBody TransactionInput transactionInput) {
        BackendCreateTransactionPayload requestData = new BackendCreateTransactionPayload();
        requestData.setTransactionInput(transactionInput);
        AclRequest aclRequest = new AclRequest(ACL_REQUEST_CREATE_ACCOUNT, requestData, apiManager, null);
        try {
            apiManager.getAclManager().process(aclRequest, null);
            BackendTransactionPayload payload = (BackendTransactionPayload) aclRequest.getResponseData();
            return payload.getTransactionInfoCollection().getTransactions().get(0);
        } catch (Exception e) {
            // TODO
            // Prepare error message and send to caller. For now, we will log only.
            log.error("RequestFailure");
            return null;
        }
    }
}
