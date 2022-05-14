package com.krasnov.bombsspringboot.repository;


import com.krasnov.bombsspringboot.domain.Bomb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BombRepository extends JpaRepository<Bomb, Integer> {
}
