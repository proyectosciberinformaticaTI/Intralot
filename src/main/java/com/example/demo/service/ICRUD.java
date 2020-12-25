package com.example.demo.service;

import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_equipo;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
    T registrar(T t);

    T modificar(T t);

    void eliminar(int id);

    Optional<T> listarId(int id);

    List<T> listar();

    tb_detalle_equipo_jugador findByEquiposJugadores(int idtb_jugador,int idtb_equipo);
}