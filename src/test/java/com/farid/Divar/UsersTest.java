package com.farid.Divar;

import com.farid.Divar.Models.User;
import com.farid.Divar.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UsersTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    private User testUser;

    @BeforeEach
    public void setup() {
//        userRepository.deleteAll();
        testUser = new User();
        testUser.setFirstName("First name Test");
        userRepository.save(testUser);
    }

//    @Test
//    public void testIndexReturnsAllUsers() throws Exception {
//        mockMvc.perform(get("/users"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is("Alice")));
//    }

    @Test
    public void testShowReturnsUserById() throws Exception {
        mockMvc.perform(get("/users/" + testUser.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("First name Test")));
    }
}
