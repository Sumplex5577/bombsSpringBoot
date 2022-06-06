package com.krasnov.bombsspringboot;
import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.repository.BombRepository;
import com.krasnov.bombsspringboot.service.BombService;
import com.krasnov.bombsspringboot.service.BombServiceBean;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class BombServiceTests {

    @Mock
    private BombRepository bombRepository;

    @InjectMocks
    private BombServiceBean bombService;

    @Test
    public void whenSaveBomb_shouldReturnBomb(){
        Bomb bomb   = new Bomb();
        bomb.setName("Kalibr");

        when(bombRepository.save(ArgumentMatchers.any(Bomb.class))).thenReturn(bomb);

        Bomb created = bombService.create(bomb);
        assertThat(created.getName()).isSameAs(bomb.getName());
        verify(bombRepository).save(bomb);

    }
    @Test
    public void whenGivenId_shouldReturnBomb_ifFound() {
        Bomb bomb = new Bomb();
        bomb.setId(55);

        when(bombRepository.findById(bomb.getId())).thenReturn(Optional.of(bomb));

        Bomb expected = bombService.viewById(bomb.getId());

        assertThat(expected).isSameAs(bomb);
//      verify(bombRepository).findById(bomb.getId());
    }
    @Test(expected = Exception.class)
    public void should_throw_exception_when_employee_doesnt_exist(){
        Bomb bomb = new Bomb();
        bomb.setId(56);
        bomb.setName("Kalibr");

        given(bombRepository.findById(anyInt())).willReturn(Optional.empty());
        bombService.viewById(bomb.getId());
    }







}
