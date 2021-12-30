package com.example.aop.after;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy     // for spring to use auto proxy in AOP
@ComponentScan("com.example.aop.after")
public class Config {



}
