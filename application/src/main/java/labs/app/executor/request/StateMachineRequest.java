package labs.app.executor.request;

import labs.app.executor.data.RequestData;
import labs.app.executor.sm.ICallback;
import labs.app.executor.sm.IState;

public class StateMachineRequest extends Request {
  private IState prevState;
  private IState currState;
  private IState nextState;
  private ICallback callback;
  private Object owner;

  public StateMachineRequest(RequestData data, Object owner, ICallback callback) {
    super(data);
    this.prevState = this.currState = this.nextState = null;
    this.callback = callback;
    this.owner = owner;
  }

  public void setPrevState(IState state) {
    this.prevState = state;
  }

  public void setCurrState(IState state) {
    this.currState = state;
  }

  public void setNextState(IState state) {
    this.nextState = state;
  }

  public IState getCurrState() {
    return this.currState;
  }

  public IState getPrevState() {
    return this.prevState;
  }

  public IState getNextState() {
    return this.nextState;
  }

  public void setCallback(ICallback callback) {
    this.callback = callback;
  }

  public ICallback getCallback(ICallback callback) {
    return this.callback;
  }

  public Object getOwner() {
    return this.owner;
  }
}
