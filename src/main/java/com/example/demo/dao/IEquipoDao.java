package com.example.demo.dao;

import com.example.demo.model.tb_detalle_equipo_jugador;
import com.example.demo.model.tb_equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEquipoDao extends JpaRepository<tb_detalle_equipo_jugador,Integer> {



    @Query(value = "SELECT j.idtb_detalle_equipo_jugador,j.idtb_equipo,pl.idtb_jugador,pl.nombre FROM intralot.tb_detalle_equipo_jugador j inner join tb_equipo p on j.idtb_equipo=p.idtb_equipo inner join tb_jugador pl on j.idtb_jugador=pl.idtb_jugador where pl.idtb_jugador=:idtb_jugador and p.idtb_equipo=:idtb_equipo", nativeQuery = true)
   tb_detalle_equipo_jugador findByEquiposJugadores(@Param("idtb_jugador") int idtb_jugador,@Param("idtb_equipo") int idtb_equipo);

}
