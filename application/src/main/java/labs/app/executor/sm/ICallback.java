package labs.app.executor.sm;

import labs.app.executor.request.StateMachineRequest;
import labs.app.executor.utils.hint.Hint;

public interface ICallback {
  void signature(StateMachineRequest r, Hint h);
}
