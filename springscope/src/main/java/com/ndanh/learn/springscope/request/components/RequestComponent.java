package com.ndanh.learn.springscope.request.components;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestScope
public class RequestComponent {
}
