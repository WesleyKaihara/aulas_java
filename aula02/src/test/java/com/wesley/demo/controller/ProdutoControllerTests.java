package com.wesley.demo.controller;

import com.wesley.demo.models.Produto;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ProdutoControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void listarProdutos() throws Exception {
        this.mockMvc.perform(get("/produtos"))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    void bucarProduto() throws Exception {
        this.mockMvc.perform(get("/produtos/0"))
            .andDo(print())
            .andExpect(status().isNotFound());
    }

    @Test
    void adicionarProdutoValido() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
            .post("/produtos")
            .content("{\"descricao\": \"Suco de Laranja\", \"valor\": 15.99}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value("Suco de Laranja"));
    }

    @Test
    void adicionarProdutoInvalido() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
            .post("/produtos")
            .content("{\"descricao\": \"Suco de Laranja\"}")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
    }

    @Test
    void atualizarProduto() throws Exception {
        this.mockMvc.perform(put("/produtos/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void removerProduto() throws Exception {
        this.mockMvc.perform(delete("/produtos/0"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
