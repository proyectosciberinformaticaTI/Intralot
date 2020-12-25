package com.example.demo.serviceImpl;

import com.example.demo.dao.IJugadorDao;
import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_jugador;
import com.example.demo.service.IJugadorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class JugadorServiceImpl implements IJugadorService {

   private IJugadorDao dao;



    @Override
    public tb_jugador registrar(tb_jugador tb_jugador) {
        return dao.save(tb_jugador);
    }

    @Override
    public tb_jugador modificar(tb_jugador tb_jugador) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Optional<tb_jugador> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<tb_jugador> listar() {
        return dao.findAll();
    }

    @Override
    public tb_detalle_equipo_jugador findByEquiposJugadores(int idtb_jugador, int idtb_equipo) {
        return null;
    }
}
