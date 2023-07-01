package com.backbase.api.controller.v1;

import com.backbase.api.controller.v1.request.transaction.TransactionInput;
import com.backbase.api.controller.v1.response.account.AccountInfo;
import com.backbase.api.controller.v1.response.error.ApiResponseError;
import com.backbase.api.controller.v1.response.transaction.TransactionInfo;
import com.backbase.api.controller.v1.response.transaction.TransactionInfoCollection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Transaction", description = "Manage transaction(s) associated with given account")
@RestController
@RequestMapping("/accounts")
public class TransactionController {
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
            @PathVariable("account_number") final String account_number) {
        TransactionInfoCollection response = new TransactionInfoCollection();
        return response;
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
        TransactionInfo response = new TransactionInfo();
        return response;
    }
}
