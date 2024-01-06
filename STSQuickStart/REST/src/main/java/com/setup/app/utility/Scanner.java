package com.setup.app.utility;

import org.springframework.context.annotation.ComponentScan;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@ComponentScan(basePackages = "com.james.Common") 
public @interface Scanner {
}
