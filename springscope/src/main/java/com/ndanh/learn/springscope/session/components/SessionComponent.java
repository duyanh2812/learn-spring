package com.ndanh.learn.springscope.session.components;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SessionScope
public class SessionComponent {
}
