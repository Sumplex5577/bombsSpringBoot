//package com.krasnov.bombsspringboot;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.krasnov.bombsspringboot.domain.Bomb;
//import com.krasnov.bombsspringboot.dto.BombDto;
//import com.krasnov.bombsspringboot.repository.BombRepository;
//import com.krasnov.bombsspringboot.utils.config.BombMapper;
//import com.krasnov.bombsspringboot.web.BombController;
//import org.assertj.core.util.Arrays;
//import org.junit.Ignore;
////import org.junit.Test;
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
//import java.util.List;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.notNullValue;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.notNullValue;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
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
//    private BombController controller;
//
//
//    @Test
//    public void createBomb_success() throws Exception {
//        Bomb bomb = Bomb.builder().name("Iskander").isNuclear(true).date(LocalDateTime.now()).weight(1000).country("UKRAINE").build();
//        BombDto dto = BombMapper.INSTANCE.bombToBombDto(bomb);
//
//        Mockito.when(controller.createBomb(dto)).thenReturn(dto);
//
//        MockHttpServletRequestBuilder mockRequest = post("/api/bombs")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto));
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().is(201));
//
//    }
//
//    @Test
//    public void getBombByIdSuccess() throws Exception {
//        Bomb bomb = Bomb.builder().name("XXX").weight(100).build();
//        BombDto dto = BombMapper.INSTANCE.bombToBombDto(bomb);
//
//        Mockito.when(controller.viewById(bomb.getId())).thenReturn(dto);
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/bombs/1").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//    }
//
////    @Ignore
////    @Test
////    public void getAllPlanesSuccess() throws Exception {
////        Bomb bomb = Bomb.builder().name("HHH").isNuclear(true).build();
////        BombDto dto = BombMapper.INSTANCE.bombToBombDto(bomb);
////
////        Collection<Bomb> records = new ArrayList<>(List.of(bomb));
////        controller.createBomb(dto);
////
////
////        Mockito.when(controller.getAllBombs()).thenReturn(records);
////
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/bombs").contentType(MediaType.APPLICATION_JSON))
////                .andExpect(status().isOk())
////                .andExpect(jsonPath("$", hasSize(1)))
////               .andExpect(jsonPath("$[0].name", is("HHH")));
////    }
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
