package labs.app.executor;

import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;
import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_INVALID;
import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_WAITING;

import java.util.Objects;
import labs.app.executor.request.Request;
import labs.app.executor.request.StateMachineRequest;
import labs.app.executor.sm.EnumExecutorEngineMode;
import labs.app.executor.sm.EnumExecutorEngineResult;
import labs.app.executor.sm.IState;
import labs.app.executor.sm.IStateMachineInventory;
import labs.app.executor.utils.hint.Hint;

public class StateMachineExecutorEngine implements IExecutorEngine {
  private EnumExecutorEngineMode mode = EnumExecutorEngineMode.EXECUTOR_MODE_NORMAL;
  private IStateMachineInventory stateMachineInventory = null;

  public StateMachineExecutorEngine(EnumExecutorEngineMode mode, IStateMachineInventory inventory)
      throws Exception {
    if (null == inventory) {
      throw new Exception("Failed to create engine object");
    }
    this.stateMachineInventory = inventory;
    this.mode = mode;
  }

  @Override
  public EnumExecutorEngineResult execute(Request request, Hint hint) throws Exception {
    EnumExecutorEngineResult stateResult = EXECUTOR_RESULT_INVALID;
    StateMachineRequest stateMachineRequest = (StateMachineRequest) request;

    /*
     * The function can be called in two situations: (1) start and (2) callback.
     * As we start first time, we do not have next state configured and need to
     * start with current state. In case of callback, we have already processed
     * current state but went on waiting, need to invoke next state so that we
     * do not end up running same state twice.
     */
    if (null != stateMachineRequest.getPrevState()) {
      /*
       * We already started as previous state is not NULL. So,
       * we are entering again because of callback.
       */
      stateMachineRequest.setPrevState(stateMachineRequest.getCurrState());
      stateMachineRequest.setCurrState(stateMachineRequest.getNextState());
      stateMachineRequest.setNextState(null);
    }

    stateResult = stateMachineRequest.getCurrState().signature(stateMachineRequest, hint);
    while (EXECUTOR_RESULT_WAITING != stateResult) {
      stateMachineRequest.setPrevState(stateMachineRequest.getCurrState());
      stateMachineRequest.setCurrState(stateMachineRequest.getNextState());
      stateMachineRequest.setNextState(null);

      stateResult = stateMachineRequest.getCurrState().signature(stateMachineRequest, hint);

      /*
       * 	Exercise specific activities if request is completed its processing.
       *  We are done with the processing of this request. So, let us do some
       *  sanity check and stay happy ever forever. In future, we might like
       *  to do more specialised processing.
       */
      if (EXECUTOR_RESULT_FINISHED == stateResult) {
        stateMachineRequest.setPrevState(stateMachineRequest.getCurrState());
        stateMachineRequest.setCurrState(null);
        return EXECUTOR_RESULT_FINISHED;
      }
    }
    return EXECUTOR_RESULT_WAITING;
  }
}
