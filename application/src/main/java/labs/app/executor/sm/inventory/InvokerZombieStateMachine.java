package labs.app.executor.sm.inventory;

import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;
import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;

import labs.app.executor.request.RequestStatus;
import labs.app.executor.request.StateMachineRequest;
import labs.app.executor.sm.AbstractStateMachine;
import labs.app.executor.sm.EnumExecutorEngineResult;
import labs.app.executor.sm.IState;
import labs.app.executor.utils.hint.Hint;

public class InvokerZombieStateMachine extends AbstractStateMachine {
  @Override
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    EnumExecutorEngineResult smStatus = EXECUTOR_RESULT_CONTINUE;
    StateMachineRequest stateMachineRequest = (StateMachineRequest) request;
    try {
      request.setStatus(RequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::collectDataState);
      IState state = request.getNextState();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return smStatus;
  }

  public EnumExecutorEngineResult collectDataState(StateMachineRequest request, Hint hint) {
    EnumExecutorEngineResult smStatus = EXECUTOR_RESULT_CONTINUE;
    try {
      request.setNextState(this::successState);
    } catch (Exception e) {
      request.setNextState(this::errorState);
      e.printStackTrace();
    }
    return smStatus;
  }

  public EnumExecutorEngineResult errorState(StateMachineRequest request, Hint hint) {
    EnumExecutorEngineResult smStatus = EXECUTOR_RESULT_FINISHED;
    try {
      request.setStatus(RequestStatus.REQUEST_FAILED);
      request.setNextState(this::finalState);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return smStatus;
  }
}
