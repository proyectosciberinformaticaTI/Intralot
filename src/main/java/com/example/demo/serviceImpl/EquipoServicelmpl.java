package com.example.demo.serviceImpl;

import com.example.demo.dao.IEquipoDao;
import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_equipo;
import com.example.demo.service.IEquipoService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EquipoServicelmpl implements IEquipoService {

    private IEquipoDao dao;


    @Override
    public tb_detalle_equipo_jugador registrar(tb_detalle_equipo_jugador tb_detalle_equipo_jugador) {
        return dao.save(tb_detalle_equipo_jugador);
    }

    @Override
    public tb_detalle_equipo_jugador modificar(tb_detalle_equipo_jugador tb_detalle_equipo_jugador) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Optional<tb_detalle_equipo_jugador> listarId(int id) {

        return dao.findById(id);
    }


    @Override
    public List<tb_detalle_equipo_jugador> listar() {
        return dao.findAll();
    }

    @Override
    public tb_detalle_equipo_jugador findByEquiposJugadores(int idtb_jugador,int idtb_equipo) {
        return dao.findByEquiposJugadores(idtb_jugador,idtb_equipo);
    }


}
