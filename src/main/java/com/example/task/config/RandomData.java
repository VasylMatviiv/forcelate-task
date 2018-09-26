package com.example.task.config;

import com.example.task.services.UserService;
import com.example.task.utils.RandomDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
@Profile("!test")
public class RandomData {
    @Autowired
    UserService userService;
    @Autowired
    EntityManager em;

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {

        for (int i = 0; i < 10; i++) {
            userService.save(RandomDataUtils.createUser());
        }
        em.clear();
    }
}
