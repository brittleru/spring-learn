package com.example.aop.pointcut.combo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy     // for spring to use auto proxy in AOP
@ComponentScan("com.example.aop.pointcut.combo")
public class Config {



}
