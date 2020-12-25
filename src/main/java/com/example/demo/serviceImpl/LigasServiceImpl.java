package com.example.demo.serviceImpl;


import com.example.demo.dao.ILigasDao;
import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_ligas_partidos;
import com.example.demo.service.IJugadorService;
import com.example.demo.service.ILigasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class LigasServiceImpl implements ILigasService {

    private ILigasDao dao;

    @Override
    public tb_ligas_partidos registrar(tb_ligas_partidos tb_ligas_partidos) {
        return dao.save(tb_ligas_partidos);
    }

    @Override
    public tb_ligas_partidos modificar(tb_ligas_partidos tb_ligas_partidos) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public Optional<tb_ligas_partidos> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<tb_ligas_partidos> listar() {
        return dao.findAll();
    }

    @Override
    public tb_detalle_equipo_jugador findByEquiposJugadores(int idtb_jugador, int idtb_equipo) {
        return null;
    }
}
