package com.anlisisadn.analizador;

import com.anlisisadn.analizador.service.MutanteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnalizadorApplicationTests {
    @Autowired(required = false)
    MutanteService mutanteService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mvc;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Listado de registros")
    public void mutantList() throws Exception {
        this.mockMvc.perform(get("/mutant")
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Estadisticas")
    public void mutantStats() throws Exception {
        this.mockMvc.perform(get("/mutant/stats")
        ).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Es Mutante")
    public void mutantIsMutant() throws Exception {
        this.mockMvc.perform(
                post("/mutant/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(("{\n" +
                                "\t\"dna\":[\"ATGCGA\",\n" +
                                "           \"CAGTGC\",\n" +
                                "           \"TTATGT\",\n" +
                                "           \"AGAAGG\",\n" +
                                "           \"CCCCTA\",\n" +
                                "           \"TCACTG\"]\n" +
                                "}")))
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("No Es Mutante")
    public void mutantIsNotMutant() throws Exception {
        this.mockMvc.perform(
                post("/mutant/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(("{\n" +
                                "\t\"dna\":[\"AATAAA\",\n" +
                                "           \"CTTTGC\",\n" +
                                "           \"TTATGT\",\n" +
                                "           \"AGACGG\",\n" +
                                "           \"CTACTA\",\n" +
                                "           \"TCACTG\"]\n" +
                                "}")))
                .andExpect(status().isForbidden());

    }

}
