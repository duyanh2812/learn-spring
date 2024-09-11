package com.ndanh.learn.springscope.common.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PrototypeComponent {
}
