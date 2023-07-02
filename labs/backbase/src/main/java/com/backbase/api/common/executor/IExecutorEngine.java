package com.backbase.api.common.executor;

import com.backbase.api.common.request.BackendRequest;
import com.backbase.api.common.utils.hint.Hint;

public interface IExecutorEngine {
  EnumExecutorEngineResult execute(BackendRequest request, Hint hint);
}
