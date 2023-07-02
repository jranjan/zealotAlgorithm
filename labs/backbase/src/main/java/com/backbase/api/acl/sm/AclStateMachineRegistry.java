package com.backbase.api.acl.sm;

import com.backbase.api.acl.request.EnumAclRequestType;
import com.backbase.api.common.executor.sm.IStateMachine;
import com.backbase.api.common.executor.sm.IStateMachineRegistry;
import com.backbase.api.common.request.IRequestType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class AclStateMachineRegistry implements IStateMachineRegistry {

  private static final Map<EnumAclRequestType, IStateMachine> stateMachineRegistry =
      new EnumMap<>(EnumAclRequestType.class);

  public AclStateMachineRegistry() {}

  @Override
  public void registerStateMachine(IRequestType requestType, IStateMachine stateMachine) {
    stateMachineRegistry.put((EnumAclRequestType) requestType, stateMachine);
  }

  @Override
  public int getCount() {
    return stateMachineRegistry.size();
  }

  @Override
  public IStateMachine getStateMachine(IRequestType type) {
    return stateMachineRegistry.get((EnumAclRequestType) type);
  }
}
