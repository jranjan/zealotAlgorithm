package labs.app.executor.factory;

/**
 * The constants define the type of executor which can process the executor. The types help to
 * instantiate different executors like state machine executor, shell script executory or python
 * script executor without worrying about how the request processing is implemented.
 *
 * @author jyoti.ranjan
 */
public enum EnumExecutorEngineType {
  EXECUTOR_ENGINE_TYPE_STATE_MACHINE
}
