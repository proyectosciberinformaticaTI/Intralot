package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_detalle_equipo_jugador")
public class tb_detalle_equipo_jugador {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtb_detalle_equipo_jugador;



    @ManyToOne
    @JoinColumn(name = "idtb_equipo", nullable = false)
    private tb_equipo equipo;



    @OneToMany(mappedBy = "idtb_jugador", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<tb_jugador> jugador;

    public tb_detalle_equipo_jugador() {

        this.jugador=new ArrayList<>();
    }

    public void addJugador(tb_jugador jug) {
        this.jugador.add(jug);
    }

    public int getIdtb_detalle_equipo_jugador() {
        return idtb_detalle_equipo_jugador;
    }

    public void setIdtb_detalle_equipo_jugador(int idtb_detalle_equipo_jugador) {
        this.idtb_detalle_equipo_jugador = idtb_detalle_equipo_jugador;
    }

    public tb_equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(tb_equipo equipo) {
        this.equipo = equipo;
    }

    public List<tb_jugador> getJugador() {
        return jugador;
    }

    public void setJugador(List<tb_jugador> jugador) {
        this.jugador = jugador;
    }
}
