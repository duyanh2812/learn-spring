package com.ndanh.learn.springscope.prototype.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class PrototypeComponent {
}
