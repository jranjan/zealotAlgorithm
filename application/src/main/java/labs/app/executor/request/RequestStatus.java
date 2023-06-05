package labs.app.executor.request;

public enum RequestStatus {
  REQUEST_CREATED,
  REQUEST_INPROGRESS,
  REQUEST_WAITING,
  REQUEST_CANCELED,
  REQUEST_ABORTED,
  REQUEST_FAILED,
  REQUEST_COMPLETED;
}