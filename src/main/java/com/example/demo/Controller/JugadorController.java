package com.example.demo.Controller;

import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_jugador;
import com.example.demo.service.IJugadorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/jugador")
public class JugadorController {


private IJugadorService service;




    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<tb_jugador>> listar(){
        List<tb_jugador> jugadores = new ArrayList<>();
        jugadores = service.listar();
        return new ResponseEntity<List<tb_jugador>>(jugadores, HttpStatus.OK);
    }







    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestBody tb_jugador jugador){


        tb_jugador que = new tb_jugador();
        if(jugador.getPosicion().equals("1")){
            jugador.setPosicion("Arquero");
        }if(jugador.getPosicion().equals("2")){
            jugador.setPosicion("Defensa");
        }if(jugador.getPosicion().equals("3")){
            jugador.setPosicion("Volante");
        }if(jugador.getPosicion().equals("4")){
            jugador.setPosicion("Defensa");
        }
        que = service.registrar(jugador);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getIdtb_jugador()).toUri();
        return ResponseEntity.created(location).build();
    }




}
