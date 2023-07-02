package com.backbase.api.api.manager;


import com.backbase.api.acl.manager.IAclManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "api", name = "manager", havingValue = "basic")
public final class BasicApiManager implements IApiManager {

  private final IAclManager aclManager;

  public BasicApiManager(IAclManager aclManager) {
    this.aclManager = aclManager;
  }

  @Override
  public void setup() {}

  @Override
  public IAclManager getAclManager() {
    return aclManager;
  }
}
