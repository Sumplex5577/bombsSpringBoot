package com.krasnov.bombsspringboot.web;
import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import com.krasnov.bombsspringboot.utils.config.BombConverter;
import com.krasnov.bombsspringboot.utils.config.BombMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.krasnov.bombsspringboot.service.BombService;

import javax.validation.Valid;
import java.util.Collection;


    @RestController
    @RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
    @AllArgsConstructor
    @Slf4j

   public class BombController implements BombSwagger {

    private final BombService bombService;

    private final BombConverter bombConverter;

    @PostMapping("/bombs")
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Bomb Created")
    public BombDto createBomb(@RequestBody @Valid BombDto requestForSave) {
       var bomb = bombConverter.getMapperFacade().map(requestForSave, Bomb.class);
       var dto = bombConverter.toDto(bombService.create(bomb));
       return dto;
    }



    @PutMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)

    public Bomb putBomb(@PathVariable("id") Integer id, @RequestBody Bomb bomb) {
    return bombService.update(id, bomb);
}

    @GetMapping("/bombs")
    public Collection<Bomb>getAllBombs() {
        return bombService.view();
    }



    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK) // just in case double check!!!
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
        //bombService.deleteAll();
    }

    @GetMapping(value = "/bombs/name", params = {"name"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByName(String name) {
        return bombService.findBombByName(name);

    }

    @GetMapping(value = "/bombs/country", params = {"country"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByCountry(String country) {
        return bombService.findBombByCountry(country);
    }

    @GetMapping(value = "/bombs/weight", params = {"weight"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByWeight(int weight) {
        return bombService.findBombByWeight(weight);

    }

    @GetMapping(value = "/bombs/nuclears", params = {"nuclearBombs"})
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> findBombByNuclear() {
        return bombService.findBombByNuclear();
    }
}



