package com.example.demo.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.example.demo.Exception.NotFoundException;
import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.service.IEquipoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
@RestController
@RequestMapping("/detalle")
public class DetalleEquipoController {

    private IEquipoService service;

    private static final Logger log = LoggerFactory.getLogger(DetalleEquipoController.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<tb_detalle_equipo_jugador>> listar(){
        List<tb_detalle_equipo_jugador> equipos = new ArrayList<>();
        equipos = service.listar();
        return new ResponseEntity<List<tb_detalle_equipo_jugador>>(equipos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public Optional<tb_detalle_equipo_jugador> listarId(@PathVariable("id") Integer id) {
       Optional<tb_detalle_equipo_jugador> eq = service.listarId(id);


        if (eq == null) {
            throw new NotFoundException("ID: " + id);
        }
        return  eq;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestBody tb_detalle_equipo_jugador equipo){


        tb_detalle_equipo_jugador equ = new tb_detalle_equipo_jugador();


//equ.setJugador(equipo.getJugador());
 equ = service.registrar(equipo);






    //  tb_detalle_equipo_jugador equ2= (tb_detalle_equipo_jugador) service.findByEquiposJugadores(equ.getJugador().get(contador).getIdtb_jugador());
    //  System.out.println("Hola mundo"+equ2);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equ.getIdtb_detalle_equipo_jugador()).toUri();
        return ResponseEntity.created(location).build();
    }



}
