package labs.app.executor.sm;

import labs.app.executor.request.StateMachineRequest;
import labs.app.executor.utils.hint.Hint;

public interface IStateMachine {
  EnumExecutorEngineResult zerothState(StateMachineRequest r, Hint hint);
  EnumExecutorEngineResult successState(StateMachineRequest r, Hint hint);
  EnumExecutorEngineResult finalState(StateMachineRequest r, Hint hint);
}
