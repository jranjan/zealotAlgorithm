package com.backbase.api.common.request;


import com.backbase.api.common.data.BackendData;
import com.backbase.api.common.executor.sm.ICallback;
import com.backbase.api.common.executor.sm.IState;
import com.backbase.api.common.manager.IManager;

public class StateMachineRequest extends BackendRequest {
  private IState prevState;
  private IState currState;
  private IState nextState;
  private ICallback callback;
  private IManager owner;

  public StateMachineRequest(BackendData data, IManager owner, ICallback callback) {
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

  public IManager getOwner() {
    return this.owner;
  }
}
