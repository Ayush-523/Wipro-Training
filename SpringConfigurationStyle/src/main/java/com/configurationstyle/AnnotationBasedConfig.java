package com.configurationstyle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// this annotation will mark the bean classes
@ComponentScan("com.dependencyinjection")
public class AnnotationBasedConfig {

}