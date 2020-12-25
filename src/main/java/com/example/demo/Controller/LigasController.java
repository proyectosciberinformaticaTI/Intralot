package com.example.demo.Controller;


import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_jugador;
import com.example.demo.model.tb_ligas_partidos;
import com.example.demo.service.ILigasService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@RestController
@RequestMapping("/ligas")
public class LigasController {

private ILigasService service;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<tb_ligas_partidos>> listar(){
        List<tb_ligas_partidos> ligas = new ArrayList<>();
        ligas = service.listar();
        return new ResponseEntity<List<tb_ligas_partidos>>(ligas, HttpStatus.OK);
    }








    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestBody tb_ligas_partidos ligas){


        tb_ligas_partidos equ = new tb_ligas_partidos();
        LocalDateTime locaDate = LocalDateTime.now();
        int hora  = locaDate.getHour();
        int minuto = locaDate.getMinute();
        int segundo = locaDate.getSecond();
ligas.setMinuto_hora_gol(hora  + ":"+ minuto +":"+segundo);
        equ = service.registrar(ligas);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equ.getIdtb_ligas_partidos()).toUri();
        return ResponseEntity.created(location).build();
    }

}
