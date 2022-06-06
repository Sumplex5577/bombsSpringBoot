package com.krasnov.bombsspringboot.web;
import com.krasnov.bombsspringboot.domain.Bomb;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.krasnov.bombsspringboot.service.BombService;

import javax.persistence.EntityNotFoundException;
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
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Bomb Created")
    public Bomb createBomb(@RequestBody Bomb bomb) {
     //   System.out.println("Bomb was saved to database successfully");
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
    @ResponseStatus(HttpStatus.OK) // just in case double check!!!
    public String viewById(@PathVariable Integer id) {
        try {
            return bombService.viewById(id).toString();
        }catch (EntityNotFoundException e) {
            return e.getLocalizedMessage();
        }
    }

    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Bomb getBomb(@PathVariable Integer id) {
        Bomb bomb = bombService.viewById(id);
        return bomb;
    }

    @PatchMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBomb(@PathVariable Integer id) { //write message to client "bomb was deleted by ID"
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
        return bombService.findBombByCountry(country);
    }

    @GetMapping(value = "/bombs", params = {"weight"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByWeight(int weight) {
        return bombService.findBombByWeight(weight);

    }

    @GetMapping(value = "/bombs/nuclears")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByNuclear() {
        return bombService.findBombByNuclear();
    }
}



