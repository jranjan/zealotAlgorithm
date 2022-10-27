package labs.app.executor.sm;

import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_CONTINUE;
import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;

import labs.app.executor.request.RequestStatus;
import labs.app.executor.request.StateMachineRequest;
import labs.app.executor.utils.hint.Hint;

public abstract class AbstractStateMachine implements IStateMachine {
  @Override
  public EnumExecutorEngineResult zerothState(StateMachineRequest request, Hint hint) {
    EnumExecutorEngineResult smStatus = EXECUTOR_RESULT_CONTINUE;
    try {
      request.setStatus(RequestStatus.REQUEST_INPROGRESS);
      request.setNextState(this::successState);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return smStatus;
  }

  public EnumExecutorEngineResult successState(StateMachineRequest request, Hint hint) {
    EnumExecutorEngineResult smStatus = EXECUTOR_RESULT_CONTINUE;
    try {
      request.setStatus(RequestStatus.REQUEST_COMPLETED);
      request.setNextState(this::finalState);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return smStatus;
  }

  @Override
  public EnumExecutorEngineResult finalState(StateMachineRequest request, Hint hint) {
    return EXECUTOR_RESULT_FINISHED;
  }
}
