package com.pablosaraiva.web.core;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class VisitorService {
    AtomicInteger visitors = new AtomicInteger(0);

    public int countAndGetVisitor() {
        return visitors.incrementAndGet();
    }
}
