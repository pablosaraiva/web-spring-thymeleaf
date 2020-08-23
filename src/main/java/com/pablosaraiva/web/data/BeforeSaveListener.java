package com.pablosaraiva.web.data;


import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;

import java.util.UUID;

@Configuration
public class BeforeSaveListener {

    @Bean
    public ApplicationListener<BeforeSaveEvent<Object>> beforeSave() {
        return event -> {
            final Object entity = event.getEntity();
            if (entity instanceof DbEntity) {
                DbEntity dbEntity = (DbEntity) entity;
                if (dbEntity.getId() == null) {
                    dbEntity.setId(UUID.randomUUID().toString());
                }
            }
        };
    }
}
