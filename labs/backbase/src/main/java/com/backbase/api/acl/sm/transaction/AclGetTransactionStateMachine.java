package com.backbase.api.acl.sm.transaction;

import com.backbase.api.acl.data.account.BackendAccountNumberPayload;
import com.backbase.api.acl.data.transaction.BackendCreateTransactionPayload;
import com.backbase.api.acl.data.transaction.BackendTransactionPayload;
import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.acl.sm.AclStateMachineRegistry;
import com.backbase.api.common.executor.EnumExecutorEngineResult;
import com.backbase.api.common.executor.sm.AbstractStateMachine;
import com.backbase.api.common.request.BackendRequestStatus;
import com.backbase.api.common.request.IRequestType;
import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;
import com.backbase.api.controller.v1.response.transaction.TransactionInfo;
import com.backbase.api.controller.v1.response.transaction.TransactionInfoCollection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

import static com.backbase.api.common.executor.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;

@Component
public class AclGetTransactionStateMachine extends AbstractStateMachine {
  public AclGetTransactionStateMachine(AclStateMachineRegistry stateMachineRegistry) {
    super(stateMachineRegistry);
  }
  @Override
  public IRequestType requestType() {
    return EnumAclRequestType.ACL_REQUEST_GET_TRANSACTION;
  }

  @Override
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    try {
      request.setStatus(BackendRequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::getTransactionInfoState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
    }
    return EXECUTOR_RESULT_CONTINUE;
  }

  public EnumExecutorEngineResult getTransactionInfoState(StateMachineRequest request, Hint hint) {
    try {
      // Get request payload
      BackendAccountNumberPayload requestPayload = (BackendAccountNumberPayload) request.getRequestData();

      // Prepare the response
      BackendTransactionPayload responsePayload = new BackendTransactionPayload();
      ArrayList<TransactionInfo> transactionList = new ArrayList<>();
      int count = new Random().nextInt(100);
      for(int i=0; i<count; i++) {
        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setTransactionId(UUID.randomUUID().toString());
        transactionInfo.setDate(java.time.LocalDate.now().toString());
        transactionList.add(transactionInfo);
      }

      TransactionInfoCollection transactionCollections = new TransactionInfoCollection();
      transactionCollections.setAccountNumber(requestPayload.getAccountNumber());
      transactionCollections.setTransactions(transactionList);
      responsePayload.setTransactionInfoCollection(transactionCollections);
      System.out.print("5");
      // Set response payload
      request.setResponseData(responsePayload);
      System.out.print("6");
      // Move to next state, as everything went good
      request.setNextState(this::successState);
    } catch (Exception exception) {
      request.setNextState(this::errorState);
    }

    return EXECUTOR_RESULT_CONTINUE;
  }
}
