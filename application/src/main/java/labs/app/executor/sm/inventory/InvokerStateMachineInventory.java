package labs.app.executor.sm.inventory;

import static labs.app.executor.factory.EnumInvokerRequestType.INVOKER_REQUEST_ZOMBIE;

import java.util.EnumMap;
import java.util.Map;
import labs.app.executor.factory.EnumInvokerRequestType;
import labs.app.executor.request.IRequestType;
import labs.app.executor.sm.IStateMachine;
import labs.app.executor.sm.IStateMachineInventory;

public class InvokerStateMachineInventory implements IStateMachineInventory {
  private boolean isReady = false;
  private static Map<EnumInvokerRequestType, IStateMachine> stateMachineInventory =
      new EnumMap<>(EnumInvokerRequestType.class);

  public InvokerStateMachineInventory() throws Exception {
    this.setup();
  }

  @Override
  public void setup() {
    this.stateMachineInventory.put(INVOKER_REQUEST_ZOMBIE, new InvokerZombieStateMachine());
    this.isReady = true;
  }

  @Override
  public int getCount() {
    return stateMachineInventory.size();
  }

  @Override
  public IStateMachine getStateMachine(IRequestType type) {
    return this.stateMachineInventory.get(type);
  }
}
