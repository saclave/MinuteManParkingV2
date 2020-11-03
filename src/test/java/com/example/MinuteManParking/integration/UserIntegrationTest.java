package com.example.MinuteManParking.integration;

import com.example.MinuteManParking.model.User;
import com.example.MinuteManParking.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserIntegrationTest {
    public static final String USER_URI = "/users";
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test // CREATE
    void should_create_user_when_create_user_given_user_details() throws Exception{
        //given
        String userAsJson = "{\n" +
                "\"firstName\": \"Chels\",\n" +
                "\"lastName\": \"Olsen\",\n" +
                "\"birthdate\": \"2002-10-10\",\n" +
                "\"gender\": \"female\",\n" +
                "\"email\": \"chels@chels.chels\",\n" +
                "\"username\": \"chels420\",\n" +
                "\"password\": \"123456789\",\n" +
                "\"cash\": 1.0\n" +
                "}";

        //when
        //then
        mockMvc.perform(post(USER_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(userAsJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.firstName").value("Chels"))
                .andExpect(jsonPath("$.lastName").value("Olsen"))
                .andExpect(jsonPath("$.birthdate").value("2002-10-10"))
                .andExpect(jsonPath("$.gender").value("female"))
                .andExpect(jsonPath("$.email").value("chels@chels.chels"))
                .andExpect(jsonPath("$.username").value("chels420"))
                .andExpect(jsonPath("$.password").value("123456789"))
                .andExpect(jsonPath("$.cash").value(1.0));
    }

    @Test //READ
    void should_return_all_users_when_get_all_given() throws Exception{
        User user = new User();
        user.setId(1);
        user.setFirstName("Laurence");
        user.setLastName("Foz");
        user.setBirthdate("null");
        user.setGender("male");
        user.setEmail("null");
        user.setUsername("null");
        user.setPassword("null");
        user.setCash(1.0);
        userRepository.save(user);

        //when
        //then
        mockMvc.perform(get(USER_URI))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].firstName").value("Laurence"))
                .andExpect(jsonPath("$[0].lastName").value("Foz"))
                .andExpect(jsonPath("$[0].birthdate").value("null"))
                .andExpect(jsonPath("$[0].gender").value("male"))
                .andExpect(jsonPath("$[0].email").value("null"))
                .andExpect(jsonPath("$[0].username").value("null"))
                .andExpect(jsonPath("$[0].password").value("null"))
                .andExpect(jsonPath("$[0].cash").value(1.0));
    }

    @Test // UPDATE
    void should_update_user_when_update_user_given_new_user_details() throws Exception{
        //given
        String userAsJson = "{\n" +
                "\"firstName\": \"Chelsea\",\n" +
                "\"lastName\": \"Olsen\",\n" +
                "\"birthdate\": \"2002-10-10\",\n" +
                "\"gender\": \"female\",\n" +
                "\"email\": \"chels@chels.chels\",\n" +
                "\"username\": \"chels420\",\n" +
                "\"password\": \"123456789\",\n" +
                "\"cash\": 1.0\n" +
                "}";

        User toSaveUser = new User();
        toSaveUser.setId(1);
        toSaveUser.setFirstName("Laurence");
        toSaveUser.setLastName("Foz");
        toSaveUser.setBirthdate("null");
        toSaveUser.setGender("male");
        toSaveUser.setEmail("null");
        toSaveUser.setUsername("null");
        toSaveUser.setPassword("null");
        toSaveUser.setCash(1.0);
        User savedUser = userRepository.save(toSaveUser);

        mockMvc.perform(put(USER_URI + "/" + savedUser.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(userAsJson))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.firstName").value("Chelsea"))
                .andExpect(jsonPath("$.lastName").value("Olsen"))
                .andExpect(jsonPath("$.birthdate").value("2002-10-10"))
                .andExpect(jsonPath("$.gender").value("female"))
                .andExpect(jsonPath("$.email").value("chels@chels.chels"))
                .andExpect(jsonPath("$.username").value("chels420"))
                .andExpect(jsonPath("$.password").value("123456789"))
                .andExpect(jsonPath("$.cash").value(1.0));
    }

    @Test // DELETE
    void should_return_when_delete_given_user_id() throws Exception{
        User toSaveUser = new User();
        toSaveUser.setId(1);
        toSaveUser.setFirstName("Laurence");
        toSaveUser.setLastName("Foz");
        toSaveUser.setBirthdate("null");
        toSaveUser.setGender("male");
        toSaveUser.setEmail("null");
        toSaveUser.setUsername("null");
        toSaveUser.setPassword("null");
        toSaveUser.setCash(1.0);
        User savedUser = userRepository.save(toSaveUser);

        mockMvc.perform(delete(USER_URI + "/" + savedUser.getId()));

        User foundUser = userRepository.findById(savedUser.getId()).orElse(null);
        assertNull(foundUser);
    }
}
