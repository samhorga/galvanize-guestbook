package guestbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guestbook.model.GuestEntry;
import guestbook.repository.GuestbookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import java.util.List;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class GuestbookControllerTest {

    @Autowired
    GuestbookRepository repository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void getAllGuests() throws Exception {
        mapper = new ObjectMapper();
        GuestEntry entry1 = repository.save(new GuestEntry("guest1", "some comment"));
        GuestEntry entry2 = repository.save(new GuestEntry("guest2", "some comment"));
        List<GuestEntry> guestEntries = List.of(entry1, entry2);
        String guestsString = mapper.writeValueAsString(guestEntries);

        mockMvc.perform(get("/guests"))
                .andExpect(status().isOk())
                .andExpect(content().string(guestsString));
    }

    @Test
    public void addGuestbookEntry() throws Exception {
        mapper = new ObjectMapper();
        GuestEntry entry1 = new GuestEntry("guest1", "some comment");
        String guestString = mapper.writeValueAsString(entry1);

        mockMvc.perform(post("/guests")
                .content(guestString)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("guestName").value("guest1"))
                .andExpect(jsonPath("comment").value("some comment"));
    }
}