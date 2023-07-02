package com.backbase.api.api.manager;

import com.backbase.api.acl.manager.IAclManager;
import com.backbase.api.common.manager.IManager;

public interface IApiManager extends IManager {
  void setup();

  IAclManager getAclManager();
}
