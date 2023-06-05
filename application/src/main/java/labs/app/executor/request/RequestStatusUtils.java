package labs.app.executor.request;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class RequestStatusUtils {

  private static final EnumMap<RequestStatus, List<RequestStatus>> requestTransitionMap =
      new EnumMap<>(RequestStatus.class);

  public static boolean isStatusTransitionAllowed(
      RequestStatus currentStatus, RequestStatus newStatus) {
    return requestTransitionMap.get(currentStatus).contains(newStatus);
  }

  // Allowed Transition statuses from one status to other
  static {
    requestTransitionMap.put(
        RequestStatus.REQUEST_CREATED,
        Arrays.asList(
            RequestStatus.REQUEST_INPROGRESS,
            RequestStatus.REQUEST_CANCELED,
            RequestStatus.REQUEST_WAITING));
    requestTransitionMap.put(
        RequestStatus.REQUEST_WAITING,
        Arrays.asList(RequestStatus.REQUEST_INPROGRESS, RequestStatus.REQUEST_CANCELED));
    requestTransitionMap.put(
        RequestStatus.REQUEST_CANCELED, Arrays.asList(RequestStatus.REQUEST_ABORTED));
    requestTransitionMap.put(
        RequestStatus.REQUEST_INPROGRESS,
        Arrays.asList(
            RequestStatus.REQUEST_CANCELED,
            RequestStatus.REQUEST_WAITING,
            RequestStatus.REQUEST_COMPLETED,
            RequestStatus.REQUEST_FAILED));
  }
}
