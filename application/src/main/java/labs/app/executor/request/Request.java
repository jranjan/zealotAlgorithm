package labs.app.executor.request;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import labs.app.executor.data.RequestData;
import labs.app.executor.data.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Request {

  private final String id;
  private final RequestData requestData;
  private ResponseData responseData;
  private final LocalDateTime createdAt;
  private RequestStatus status;
  private LocalDateTime startedAt;
  private LocalDateTime finishedAt;
  private boolean requestStartedFlag;
  private ArrayList<Request> requests = new ArrayList<Request>();
  public static final LocalDateTime INVALID_TIME = LocalDateTime.MAX;


  public Request(RequestData data) {
    this.id = UUID.randomUUID().toString();
    this.requestData = data;
    this.responseData = null;
    this.createdAt = LocalDateTime.now();
    this.status = RequestStatus.REQUEST_CREATED;
    this.requestStartedFlag = false;
    this.finishedAt = INVALID_TIME;
  }

  public List<Request> getChildRequests() {
    return requests;
  }

  public boolean addChildRequest(Request request) {
    return this.requests.add(request);
  }

  public String getId() {
    return id;
  }

  public RequestData getRequestData() {
    return requestData;
  }

  public ResponseData getResponseData() {
    return responseData;
  }

  public void setResponseData(ResponseData responseData) {
    this.responseData = responseData;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public RequestStatus getStatus() {
    return status;
  }

  public void setStatus(RequestStatus status) throws Exception {
    Logger log = LoggerFactory.getLogger(Request.class);
    if (!RequestStatusUtils.isStatusTransitionAllowed(this.getStatus(), status)) {
      throw new Exception("Failed to set status");
    }

    switch (this.status) {
      case REQUEST_CREATED:
      case REQUEST_WAITING:
        this.status = status;
        if (status.equals(RequestStatus.REQUEST_INPROGRESS)) {
          this.requestStartedFlag = true;
          this.startedAt = LocalDateTime.now();
        }
        break;

      case REQUEST_CANCELED:
        this.status = status;
        this.finishedAt = LocalDateTime.now();
        break;

      case REQUEST_INPROGRESS:
        this.status = status;
        if (status.equals(RequestStatus.REQUEST_COMPLETED)
            || status.equals(RequestStatus.REQUEST_FAILED)) {
          this.finishedAt = LocalDateTime.now();
        }
        break;
    }
  }

  public LocalDateTime getStartedAt() {
    return startedAt;
  }

  public LocalDateTime getFinishedAt() {
    return finishedAt;
  }

  public long getAge() {
    if (!finishedAt.isEqual(INVALID_TIME)) {
      return ChronoUnit.SECONDS.between(finishedAt, createdAt);
    } else {
      return ChronoUnit.SECONDS.between(LocalDateTime.now(), createdAt);
    }
  }

  public long getAgeSinceStarted() {
    if (this.requestStartedFlag) {
      return ChronoUnit.SECONDS.between(LocalDateTime.now(), startedAt);
    }
    return 0;
  }

  public long getProcessingAge() {
    if (this.requestStartedFlag) {
      if (!finishedAt.isEqual(INVALID_TIME)) {
        return ChronoUnit.SECONDS.between(finishedAt, startedAt);
      } else if (finishedAt.isEqual(INVALID_TIME)) {
        return ChronoUnit.SECONDS.between(LocalDateTime.now(), createdAt);
      }
    }
    return 0;
  }
}
