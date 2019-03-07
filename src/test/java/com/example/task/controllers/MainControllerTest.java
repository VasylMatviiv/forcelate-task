package com.example.task.controllers;


import com.example.task.entity.User;
import com.example.task.services.UserService;
import com.example.task.utils.RandomDataUtils;
import com.example.task.utils.Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class MainControllerTest {

    private User user;
    private int size;
    private List<User> users = new ArrayList<>();
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;


    @Before
    public void before() {
        reset(userService);
        user = RandomDataUtils.createUser();
        user.setId(5);
        size = (int) (0 + Math.random() * 5);
        for (int i = 0; i < size; i++) {
            users.add(RandomDataUtils.createUser());
        }
    }

    @Test
    public void testGetAllUsers() throws Exception {
        when(userService.getAll()).thenReturn(users);
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(size)))
                .andExpect(jsonPath("$[0].name", is(users.get(0).getName())))
                .andExpect(jsonPath("$[0].age", is(users.get(0).getAge())));

        verify(userService, times(1)).getAll();
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testSaveUser() throws Exception {
        when(userService.save(user)).thenReturn(user);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(Utils.convertObjectToJsonBytes(user))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is((int) user.getId())))
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.age", is(user.getAge())));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userService, times(1)).save(userCaptor.capture());
        verifyNoMoreInteractions(userService);

    }


}