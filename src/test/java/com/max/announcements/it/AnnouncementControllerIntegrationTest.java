package com.max.announcements.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test-it")
public class AnnouncementControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAnnouncementByIdIs200OK() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/announcements/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Author1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.text").value("Text1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.votes").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("author1@example.com"));
    }

    @Test
    public void testGetAnnouncementByIdIs404NotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/announcements/{id}", 99)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // Add more test methods for other controller endpoints as needed
}
