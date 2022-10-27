package labs.app.executor.factory;


import labs.app.executor.IExecutorEngine;
import labs.app.executor.StateMachineExecutorEngine;
import labs.app.executor.sm.EnumExecutorEngineMode;
import labs.app.executor.sm.IStateMachineInventory;

/**
 * A factory (or virtual constructor) to create the ExecutorEngine of different types.
 *
 * @author jyoti.ranjan
 */
public class ExecutorEngineFactory {
  public static IExecutorEngine createExecutorEngine(
      EnumExecutorEngineType type, EnumExecutorEngineMode mode, IStateMachineInventory inventory)
      throws Exception {

    switch (type) {
      case EXECUTOR_ENGINE_TYPE_STATE_MACHINE:
        return new StateMachineExecutorEngine(mode, inventory);
    }

    throw new Exception("Failed to create executor engine");
  }
}
