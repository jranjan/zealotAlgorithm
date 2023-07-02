package com.backbase.api.common.executor.sm;

import com.backbase.api.common.request.IRequestType;

public interface IStateMachineRegistry {

  void registerStateMachine(IRequestType requestType, IStateMachine stateMachine);

  int getCount();

  IStateMachine getStateMachine(IRequestType type);
}
