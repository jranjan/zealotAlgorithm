package labs.app.executor;

import static labs.app.executor.factory.EnumInvokerRequestType.INVOKER_REQUEST_ZOMBIE;

import labs.app.executor.data.RequestData;
import labs.app.executor.invoker.Invoker;
import labs.app.executor.request.InvokerRequest;

public class Entry {
  public void run() {
    try {
      Invoker invoker = new Invoker();
      InvokerRequest request = new InvokerRequest(INVOKER_REQUEST_ZOMBIE, new RequestData(),this, null);
      invoker.process(request, null);
      } catch (Exception e) {
      System.out.println("Failed to run state machine");
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
      Entry entry = new Entry();
      entry.run();
  }
}
