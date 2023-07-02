package com.backbase.api.controller.v1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.backbase.api.acl.request.AclRequest;
import com.backbase.api.common.request.BackendRequestStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ControllerUtils {

  public static boolean isFailed(AclRequest aclRequest) {
    return aclRequest.getStatus().equals(BackendRequestStatus.REQUEST_FAILED);
  }

  public static boolean isValidUUID(String uuid) {
    if (uuid == null) {
      return false;
    }
    String regex = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(uuid);
    return m.matches();
  }
}
