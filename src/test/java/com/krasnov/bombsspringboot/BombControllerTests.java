//package com.krasnov.bombsspringboot;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.krasnov.bombsspringboot.domain.Bomb;
//import com.krasnov.bombsspringboot.repository.BombRepository;
//import org.assertj.core.util.Arrays;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Collection;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.notNullValue;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.notNullValue;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
////@WebFluxTest
//@SpringBootTest(classes = BombsSpringBootApplication.class)
//@AutoConfigureMockMvc
//
//public class BombControllerTests {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    ObjectMapper mapper;
//
//    @MockBean
//    BombRepository bombRepository;
//  //  @MockBean
//   // private BombConverter converter;
//
//    @Ignore
//    @Test
//    public void createBomb_success() throws Exception {
//        Bomb bomb = Bomb.builder().name("Iskander").isNuclear(true).date(LocalDateTime.now()).weight(1000).country("UKRAINE").build();
//    //    BombDto dto = converter.toDto(bomb);
//
//        Mockito.when(bombRepository.save(bomb)).thenReturn(bomb);
//
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/bombs")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(this.mapper.writeValueAsString(bomb));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.firstNameBomb", is("Iskander")));
//
//    }
//    @Ignore
//    @Test
//    public void getBombByIdSuccess() throws Exception {
//        Bomb bomb = Bomb.builder().name("XXX").weight(100).build();
//    //    BombDto dto = converter.toDto(bomb);
//
//        Mockito.when(bombRepository.findById(bomb.getId())).thenReturn(java.util.Optional.of(bomb));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/planes/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$.firstName", is("XXX")));
//
//    }
//
//    @Ignore
//    @Test
//    public void getAllPlanesSuccess() throws Exception {
//        Bomb bomb = Bomb.builder().name("F-18").isNuclear(true).build();
//   //     BombDto dto = converter.toDto(bomb);
//
//        Collection<Bomb> records = new ArrayList<>(Arrays.asList(bomb));
//        bombRepository.save(bomb);
//
//
//        Mockito.when(bombRepository.findAll()).thenReturn(records);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/bombs")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[1].firstNameBrand", is("F-18")));
//    }
//}
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
//
//
