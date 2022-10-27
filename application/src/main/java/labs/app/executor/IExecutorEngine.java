package labs.app.executor;

import labs.app.executor.request.Request;
import labs.app.executor.sm.EnumExecutorEngineResult;
import labs.app.executor.utils.hint.Hint;

public interface IExecutorEngine {
  public EnumExecutorEngineResult execute(Request request, Hint hint) throws Exception;
}
