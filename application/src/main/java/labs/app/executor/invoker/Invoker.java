package labs.app.executor.invoker;

import static labs.app.executor.sm.EnumExecutorEngineResult.EXECUTOR_RESULT_FINISHED;

import labs.app.executor.StateMachineExecutorEngine;
import labs.app.executor.factory.EnumExecutorEngineType;
import labs.app.executor.factory.ExecutorEngineFactory;
import labs.app.executor.request.InvokerRequest;
import labs.app.executor.sm.EnumExecutorEngineMode;
import labs.app.executor.sm.EnumExecutorEngineResult;
import labs.app.executor.sm.IStateMachine;
import labs.app.executor.sm.inventory.InvokerStateMachineInventory;
import labs.app.executor.utils.hint.Hint;

public class Invoker {

  private EnumExecutorEngineMode mode;
  private InvokerStateMachineInventory stateMachineInventory;
  private StateMachineExecutorEngine stateMachineEngine;

  public Invoker() {
    try {
      this.mode = EnumExecutorEngineMode.EXECUTOR_MODE_NORMAL;
      this.stateMachineInventory = new InvokerStateMachineInventory();
      this.stateMachineEngine =
          (StateMachineExecutorEngine)
              ExecutorEngineFactory.createExecutorEngine(
                  EnumExecutorEngineType.EXECUTOR_ENGINE_TYPE_STATE_MACHINE,
                  mode,
                  stateMachineInventory);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void process(InvokerRequest request, Hint hint) throws Exception {
    System.out.println("1");
    IStateMachine stateMachine = this.stateMachineInventory.getStateMachine(request.getType());
    System.out.println("2");
    request.setCurrState(stateMachine::zerothState);
    System.out.println("3");
    EnumExecutorEngineResult stateMachineResult = this.stateMachineEngine.execute(request, null);
    System.out.println("4");
    if (EXECUTOR_RESULT_FINISHED != stateMachineResult) {
      throw new Exception("Failed to process the request");
    }
  }
}
