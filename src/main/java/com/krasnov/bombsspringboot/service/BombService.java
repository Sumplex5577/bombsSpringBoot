package com.krasnov.bombsspringboot.service;

import com.krasnov.bombsspringboot.domain.Bomb;

import java.util.List;

public interface BombService {
    /**
     * Persists new bomb to database.
     *
     * @param bomb - bomb to persist.
     * @return -  make bomb.
     */

    Bomb create(Bomb bomb);

    List<Bomb> view();

    Bomb viewById(Integer id);

    Bomb update(Integer id, Bomb bomb);

    void delete(Integer id);

    void deleteAll();
}

