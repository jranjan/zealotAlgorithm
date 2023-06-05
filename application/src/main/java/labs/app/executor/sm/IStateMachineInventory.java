package labs.app.executor.sm;

import labs.app.executor.request.IRequestType;

public interface IStateMachineInventory {
  void setup() throws Exception;

  int getCount();

  IStateMachine getStateMachine(IRequestType type) throws Exception;
}
