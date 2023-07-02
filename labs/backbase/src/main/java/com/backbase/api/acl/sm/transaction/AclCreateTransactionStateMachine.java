package com.backbase.api.acl.sm.transaction;

import com.backbase.api.acl.data.account.BackendAccountPayload;
import com.backbase.api.acl.data.account.BackendCreateAccountPayload;
import com.backbase.api.acl.data.transaction.BackendCreateTransactionPayload;
import com.backbase.api.acl.data.transaction.BackendTransactionPayload;
import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.acl.sm.AclStateMachineRegistry;
import com.backbase.api.common.data.BackbaseGlobalData;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.executor.sm.AbstractStateMachine;
import com.backbase.api.common.request.BackendRequestStatus;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import com.backbase.api.controller.v1.request.account.AccountCreationInput;
import com.backbase.api.controller.v1.request.transaction.TransactionCreationInput;
import com.backbase.api.controller.v1.response.account.AccountInfo;
import com.backbase.api.controller.v1.response.transaction.TransactionInfo;
import com.backbase.api.controller.v1.response.transaction.TransactionInfoCollection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.UUID;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;

@Component
public class AclCreateTransactionStateMachine extends AbstractStateMachine {

  public AclCreateTransactionStateMachine(AclStateMachineRegistry stateMachineRegistry) {
    super(stateMachineRegistry);
  }

  @Override
  public IRequestType requestType() {
    return EnumAclRequestType.ACL_REQUEST_CREATE_TRANSACTION;
  }

  @Override
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    try {
      request.setStatus(BackendRequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::createTransactionState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult createTransactionState(StateMachineRequest request, Hint hint) {
    try {
      System.out.println("EnumExecutorEngineResult createTransactionState(S");
      // Get request payload
      BackendCreateTransactionPayload requestPayload = (BackendCreateTransactionPayload) request.getRequestData();
      TransactionCreationInput userAccountInput = requestPayload.getTransactionInput();

      // Prepare the response
      BackendTransactionPayload responsePayload = new BackendTransactionPayload();

      ArrayList<TransactionInfo> transactionList = new ArrayList<>();
      TransactionInfo transactionInfo = new TransactionInfo();
      transactionInfo.setTransactionId(UUID.randomUUID().toString());
      transactionInfo.setDate(java.time.LocalDate.now().toString());
      transactionList.add(transactionInfo);

      TransactionInfoCollection transactionCollections = new TransactionInfoCollection();
      transactionCollections.setAccountNumber(requestPayload.getAccountNumber());
      transactionCollections.setTransactions(transactionList);
      responsePayload.setTransactionInfoCollection(transactionCollections);

      // Set response payload
      request.setResponseData(responsePayload);

      // Move to next state, as everything went good
      request.setNextState(this::successState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }
}
