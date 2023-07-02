package com.backbase.api.acl.manager;

import com.backbase.api.common.manager.IManager;
import com.backbase.api.common.request.BackendRequest;
import com.backbase.api.common.utils.hint.Hint;
import com.backbase.api.exc.executor.ExecutorEngineException;
import com.backbase.api.exc.request.RequestException;

public interface IAclManager extends IManager {
  void process(BackendRequest request, Hint hint) throws RequestException;
}
