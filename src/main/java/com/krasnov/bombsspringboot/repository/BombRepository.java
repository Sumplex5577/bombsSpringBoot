package com.krasnov.bombsspringboot.repository;


import com.krasnov.bombsspringboot.domain.Bomb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BombRepository extends JpaRepository<Bomb, Integer> {
    List<Bomb> findByName(String name);
    List<Bomb> findByCountry(String country);
    List<Bomb> findByWeight(int weight);

    @Query("select b from Bomb b where b.isNuclear = true")

 //   @Query("select b from Bomb b where b.isNuclear = true or b.isDeleted = false ")

    List<Bomb> findByNuclear();
  //  List<Bomb> findAllByDeletedIsFalse();
}
