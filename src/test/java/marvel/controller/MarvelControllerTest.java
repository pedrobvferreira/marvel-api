package marvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class MarvelControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void findAllCharactersIdTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/characters"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andReturn();
    }
    
    @Test
    void getCharacter_nonexistentID() throws Exception {
        int characterId = 0;
        mvc.perform(MockMvcRequestBuilders.get("/characters/" + characterId))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.message").value("Character id [" + characterId + "]"));
    }

    @Test
    void getCharacterIdIdTest() throws Exception {
        int characterId = 1009146;
        mvc.perform(MockMvcRequestBuilders.get("/characters/" + characterId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1009146))
                .andExpect(jsonPath("$.name").value("Abomination (Emil Blonsky)"))
                .andExpect(jsonPath("$.description").value("Formerly known as Emil Blonsky, a spy of Soviet Yugoslavian origin working for the KGB, the Abomination gained his powers after receiving a dose of gamma radiation similar to that which transformed Bruce Banner into the incredible Hulk."))
                .andReturn();
    }
}
