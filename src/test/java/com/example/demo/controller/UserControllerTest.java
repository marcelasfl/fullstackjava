package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService userService;

  private User user;

  @BeforeEach
  void setUp() {
    user = new User();
    user.setId(1L);
    user.setName("John Doe");
    user.setEmail("john.doe@example.com");
  }

  @Test
  void testCreateUser() throws Exception {
    when(userService.createUser(any(User.class))).thenReturn(user);

    mockMvc.perform(post("/api/users")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("John Doe"))
        .andExpect(jsonPath("$.email").value("john.doe@example.com"));

    verify(userService, times(1)).createUser(any(User.class));
  }

  @Test
  void testGetAllUsers() throws Exception {
    when(userService.getAllUsers()).thenReturn(Arrays.asList(user));

    mockMvc.perform(get("/api/users"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("John Doe"));

    verify(userService, times(1)).getAllUsers();
  }

  @Test
  void testGetUserById() throws Exception {
    when(userService.getUserById(1L)).thenReturn(Optional.of(user));

    mockMvc.perform(get("/api/users/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("John Doe"));

    verify(userService, times(1)).getUserById(1L);
  }

  @Test
  void testUpdateUser() throws Exception {
    when(userService.updateUser(eq(1L), any(User.class))).thenReturn(user);

    mockMvc.perform(put("/api/users/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("John Doe"));

    verify(userService, times(1)).updateUser(eq(1L), any(User.class));
  }

  @Test
  void testDeleteUser() throws Exception {
    doNothing().when(userService).deleteUser(1L);

    mockMvc.perform(delete("/api/users/1"))
        .andExpect(status().isNoContent());

    verify(userService, times(1)).deleteUser(1L);
  }
}
