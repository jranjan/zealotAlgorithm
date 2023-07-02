package com.backbase.api.common.request;

import com.backbase.api.common.data.BackendData;
import com.backbase.api.exc.request.RequestErrorMessage;
import com.backbase.api.exc.request.RequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BackendRequest {
  private final String id;
  private final BackendData requestData;
  private BackendData responseData;
  private final LocalDateTime createdAt;
  private BackendRequestStatus status;
  private LocalDateTime startedAt;
  private LocalDateTime finishedAt;
  private boolean requestStartedFlag;
  private ArrayList<BackendRequest> requests = new ArrayList<BackendRequest>();
  public static final LocalDateTime INVALID_TIME = LocalDateTime.MAX;


  public BackendRequest(BackendData data) {
    this.id = UUID.randomUUID().toString();
    this.requestData = data;
    this.responseData = null;
    this.createdAt = LocalDateTime.now();
    this.status = BackendRequestStatus.REQUEST_CREATED;
    this.requestStartedFlag = false;
    this.finishedAt = INVALID_TIME;
  }

  public List<BackendRequest> getChildRequests() {
    return requests;
  }

  public boolean addChildRequest(BackendRequest request) {
    return this.requests.add(request);
  }

  public String getId() {
    return id;
  }

  public BackendData getRequestData() {
    return requestData;
  }

  public BackendData getResponseData() {
    return responseData;
  }

  public void setResponseData(BackendData responseData) {
    this.responseData = responseData;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public BackendRequestStatus getStatus() {
    return status;
  }

  public void setStatus(BackendRequestStatus status) throws RequestException {
    Logger log = LoggerFactory.getLogger(BackendRequest.class);
    if (!BackendRequestStatusUtils.isStatusTransitionAllowed(this.getStatus(), status)) {
      throw new RequestException(RequestErrorMessage.FAILED_TO_UPDATE_STATUS);
    }

    switch (this.status) {
      case REQUEST_CREATED:
      case REQUEST_WAITING:
        this.status = status;
        if (status.equals(BackendRequestStatus.REQUEST_INPROGRESS)) {
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
        if (status.equals(BackendRequestStatus.REQUEST_COMPLETED)
            || status.equals(BackendRequestStatus.REQUEST_FAILED)) {
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
