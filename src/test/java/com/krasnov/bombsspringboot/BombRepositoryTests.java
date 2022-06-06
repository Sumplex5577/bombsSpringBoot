package com.krasnov.bombsspringboot;
import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.repository.BombRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BombRepositoryTests {

    @Autowired
    private BombRepository bombRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveBombTest() {
        Bomb bomb = Bomb.builder().name("Iskander").weight(1000).country("Ukraine").build();
        bombRepository.save(bomb);
        Assertions.assertThat(bomb.getId()).isGreaterThan(0);

    }
    @Test
    @Order(2)
    public void findByNameTest(){
        List<Bomb> bombList = bombRepository.findByName("Iskander");
        Assertions.assertThat(bombList.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void getBombTest(){
        Bomb bomb = bombRepository.findById(1).orElseThrow();
        Assertions.assertThat(bomb.getId()).isEqualTo(1);

    }


    @Test
    @Order(4)
    public void getListOfBombTest(){
        List<Bomb> bombList = bombRepository.findAll();
        Assertions.assertThat(bombList.size()).isGreaterThan(0);
    }
    @Test
    @Order(5)
    private void ByWeightTest(){
        List<Bomb> bombList = bombRepository.findByWeight(1000);
        Assertions.assertThat(bombList.size()).isGreaterThan(1);

    }


    @Test
    @Order(6)
    @Rollback(value = false)
    public void updateBombTest(){
        Bomb bomb = bombRepository.findById(1).get();
        bomb.setName("Iskander");
        Bomb bombUpdated = bombRepository.save(bomb);
        Assertions.assertThat(bombUpdated.getName()).isEqualTo("Iskander");
    }
    @Test
    @Order(7)
    public void findByCountryTest(){
        List<Bomb> bombList = bombRepository.findByCountry("Ukraine");
        Assertions.assertThat(bombList.size()).isGreaterThan(0);
    }


    @Test
    @Order(8)
    @Rollback(value = false)
    public void deleteBombTest(){
        Bomb bomb = bombRepository.findById(1).get();

        bombRepository.delete(bomb);

        List<Bomb> bomb1 = null;

          Optional<List<Bomb>> optionalAuthor = Optional.ofNullable(bombRepository.findByName("Iskander"));
        if (optionalAuthor.isPresent()) {
            bomb1 = optionalAuthor.get();
        }

        Assertions.assertThat(bomb1).isEmpty();
    }



}
