package com.backbase.api.acl.request;

import com.backbase.api.common.data.BackendData;
import com.backbase.api.common.executor.sm.ICallback;
import com.backbase.api.common.manager.IManager;
import com.backbase.api.common.request.StateMachineRequest;

public class AclRequest extends StateMachineRequest {
  EnumAclRequestType requestType;

  public AclRequest(EnumAclRequestType type, BackendData data, IManager owner, ICallback callback) {
    super(data, owner, callback);
    this.requestType = type;
  }

  public EnumAclRequestType getType() {
    return this.requestType;
  }
}
