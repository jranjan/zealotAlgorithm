package com.backbase.api.common.request;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class BackendRequestStatusUtils {

  private static final EnumMap<BackendRequestStatus, List<BackendRequestStatus>> requestTransitionMap =
      new EnumMap<>(BackendRequestStatus.class);

  public static boolean isStatusTransitionAllowed(
          BackendRequestStatus currentStatus, BackendRequestStatus newStatus) {
    return requestTransitionMap.get(currentStatus).contains(newStatus);
  }

  // Allowed Transition statuses from one status to other
  static {
    requestTransitionMap.put(
        BackendRequestStatus.REQUEST_CREATED,
        Arrays.asList(
            BackendRequestStatus.REQUEST_INPROGRESS,
            BackendRequestStatus.REQUEST_CANCELED,
            BackendRequestStatus.REQUEST_WAITING));
    requestTransitionMap.put(
        BackendRequestStatus.REQUEST_WAITING,
        Arrays.asList(BackendRequestStatus.REQUEST_INPROGRESS, BackendRequestStatus.REQUEST_CANCELED));
    requestTransitionMap.put(
        BackendRequestStatus.REQUEST_CANCELED, Arrays.asList(BackendRequestStatus.REQUEST_ABORTED));
    requestTransitionMap.put(
        BackendRequestStatus.REQUEST_INPROGRESS,
        Arrays.asList(
            BackendRequestStatus.REQUEST_CANCELED,
            BackendRequestStatus.REQUEST_WAITING,
            BackendRequestStatus.REQUEST_COMPLETED,
            BackendRequestStatus.REQUEST_FAILED));
  }
}
