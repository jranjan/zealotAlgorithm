package com.backbase.api.common.executor.sm;

import com.backbase.api.common.request.StateMachineRequest;
import com.backbase.api.common.utils.hint.Hint;

public interface ICallback {
  void signature(StateMachineRequest request, Hint hint);
}
