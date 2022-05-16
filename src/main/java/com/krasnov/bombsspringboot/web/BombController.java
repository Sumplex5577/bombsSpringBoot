package com.krasnov.bombsspringboot.web;
import com.krasnov.bombsspringboot.domain.Bomb;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.krasnov.bombsspringboot.service.BombService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BombController {
    private final BombService bombService;

    public BombController(BombService bombService) {
        this.bombService = bombService;
    }

    @PostMapping("/bombs")
    @ResponseStatus(HttpStatus.CREATED)
    public Bomb createBomb(@RequestBody Bomb bomb) {
        return bombService.create(bomb);
    }

    @PutMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bomb putBomb(@PathVariable("id") Integer id, @RequestBody Bomb bomb) {
        return bombService.update(id, bomb);
    }

    @GetMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> getAllBombs() {
        return bombService.view();
    }

    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bomb getBomb(@PathVariable Integer id) {
        return bombService.viewById(id);
    }

    @DeleteMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBomb(@PathVariable Integer id) {
        bombService.delete(id);
    }

    @DeleteMapping("/bombs")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllBombs() {
        bombService.deleteAll();
    }

    @GetMapping(value = "/bombs", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByName(String name) {
        return bombService.findBombByName(name);

    }

    @GetMapping(value = "/bombs", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByCountry(String country) {
        return bombService.findBombByName(country);
    }
}




