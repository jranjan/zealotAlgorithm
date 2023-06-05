package labs.app.executor.request;

import labs.app.executor.data.RequestData;
import labs.app.executor.factory.EnumInvokerRequestType;
import labs.app.executor.sm.ICallback;

public class InvokerRequest extends StateMachineRequest {
  EnumInvokerRequestType requestType;

  public InvokerRequest(EnumInvokerRequestType type, RequestData data, Object owner, ICallback callback) {
    super(data, owner, callback);
    this.requestType = type;
  }

  public EnumInvokerRequestType getType() {
    return this.requestType;
  }
}
