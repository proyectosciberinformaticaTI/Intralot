package com.example.demo.Controller;


import com.example.demo.model.tb_equipo;
import com.example.demo.service.IEquiposService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/equipo")
public class EquipoController {

private IEquiposService service;


    private static final Logger log = LoggerFactory.getLogger(EquipoController.class);


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<tb_equipo>> listar(){
        List<tb_equipo> equipo = new ArrayList<>();
        equipo = service.listar();
        return new ResponseEntity<List<tb_equipo>>(equipo, HttpStatus.OK);
    }







    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> registrar(@RequestBody tb_equipo equipo){
        Optional<tb_equipo> o = service.listarId(equipo.getIdtb_equipo());
        if(o.isPresent()) {
            log.info("No se registra");
            return ResponseEntity.notFound().build();
        }

        tb_equipo que = new tb_equipo();

        que = service.registrar(equipo);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(que.getIdtb_equipo()).toUri();
        return ResponseEntity.created(location).build();
    }




}
