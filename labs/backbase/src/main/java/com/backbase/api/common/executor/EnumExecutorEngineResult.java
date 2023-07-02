package com.backbase.api.common.executor;


/**
 * The constants define the result type to be returned by an executor. The result value of
 * EXECUTOR_RESULT_FINISHED indicated whether a request was completed processing or not. It should
 * be distinct from the request status. It is the same even if request processing of the request
 * failed.
 *
 * @author jyoti.ranjan
 */
public enum EnumExecutorEngineResult {
  EXECUTOR_RESULT_INVALID,
  EXECUTOR_RESULT_CONTINUE,
  EXECUTOR_RESULT_WAITING,
  EXECUTOR_RESULT_FINISHED
}
