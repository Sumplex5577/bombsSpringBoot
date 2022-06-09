package com.krasnov.bombsspringboot.web;
import com.krasnov.bombsspringboot.domain.Bomb;
import com.krasnov.bombsspringboot.dto.BombDto;
import com.krasnov.bombsspringboot.utils.config.BombMapper;
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
public class BombController {
    private final BombService bombService;

    @PostMapping("/bombs")
    @ResponseStatus(value = HttpStatus.CREATED,reason = "Bomb Created")
    public BombDto createBomb(@RequestBody @Valid BombDto bombForSave) {
        Bomb bomb = BombMapper.INSTANCE.bombDtoToBomb(bombForSave);;
        return BombMapper.INSTANCE.bombToBombDto(bomb);
    }

//    @PutMapping("/bombs/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Bomb putBomb(@PathVariable("id") Integer id, @RequestBody Bomb bomb) {
//        return bombService.update(id, bomb);
//    }
@PutMapping("/planes/{id}")
@ResponseStatus(HttpStatus.OK)
public BombDto putBomb(@RequestBody @Valid BombDto bombForUpdate, @PathVariable Integer id) {
    log.debug("updateById() Controller - start: id = {}", id);
    Bomb bomb = BombMapper.INSTANCE.bombDtoToBomb(bombForUpdate);
    log.debug("updateById() Controller - end: id = {}", id);
    return BombMapper.INSTANCE.bombToBombDto(bomb);
}

    @GetMapping("/bombs")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Bomb> getAllBombs() {
        return bombService.view();
    }

    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK) // just in case double check!!!
    public BombDto viewById(@PathVariable Integer id) {
    log.debug("viewById() Controller - start: id = {}", id);
    Bomb bomb = bombService.viewById(id);
    log.debug("viewById() Controller - to dto start: id = {}", id);
    BombDto dto = BombMapper.INSTANCE.bombToBombDto(bomb);
    log.debug("viewById() Controller - end: name = {}", dto.name);
    return dto;


    }

    @GetMapping("/bombs/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BombDto getBomb(@PathVariable Integer id) {
        log.debug("getBomb() Controller - start: id = {}", id);
        Bomb bomb = bombService.viewById(id);
        log.debug("getById() Controller - to dto start: id = {}", id);
        BombDto dto = BombMapper.INSTANCE.bombToBombDto(bomb);
        log.debug("getById() Controller - end: name = {}", dto.name);
        return dto;
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



