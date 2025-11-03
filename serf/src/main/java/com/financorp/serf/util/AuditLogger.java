package com.financorp.serf.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class AuditLogger {

    public void log(String mensaje) {
        System.out.println("[AUDITORÍA] " + LocalDateTime.now() + " - " + mensaje);
    }
}
