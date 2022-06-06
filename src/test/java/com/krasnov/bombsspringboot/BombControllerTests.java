//package com.krasnov.bombsspringboot;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.krasnov.bombsspringboot.domain.Bomb;
//import com.krasnov.bombsspringboot.repository.BombRepository;
//import org.hamcrest.CoreMatchers;
//import org.hamcrest.Matchers;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.notNullValue;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebFluxTest
//public class BombControllerTests {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    BombRepository bombRepository;
//
//    @Ignore
//    @Test
//    public void createBomb_success() throws Exception {
//        Bomb bomb = Bomb.builder().name("Iskander").weight(1000).country("UKRAINE").build();
//
//        Mockito.when(bombRepository.save(bomb)).thenReturn(bomb);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/bombs")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(bomb));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.firstName", CoreMatchers.is("John"))); /// Corematchers.is
//
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
