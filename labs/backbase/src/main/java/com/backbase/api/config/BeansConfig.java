package com.backbase.api.config;


import com.backbase.api.api.manager.BasicApiManager;
import com.backbase.api.api.manager.IApiManager;
import com.backbase.api.common.executor.sm.StateMachineExecutorEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

  public BeansConfig() {
  }
  @Bean
  public StateMachineExecutorEngine stateMachineExecutorEngine() {
    return new StateMachineExecutorEngine();
  }
}
