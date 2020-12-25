package com.example.demo.serviceImpl;

import com.example.demo.dao.IEquiposDao;
import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_equipo;
import com.example.demo.service.IEquipoService;
import com.example.demo.service.IEquiposService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EquiposServiceImpl implements IEquiposService {

  private IEquiposDao dao;

    @Override
    public tb_equipo registrar(tb_equipo equipo) {
        return dao.save(equipo);
    }

    @Override
    public tb_equipo modificar(tb_equipo equipo) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Optional<tb_equipo> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<tb_equipo> listar() {
        return dao.findAll();
    }

    @Override
    public tb_detalle_equipo_jugador findByEquiposJugadores(int idtb_jugador, int idtb_equipo) {
        return null;
    }
}
