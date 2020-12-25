package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_ligas_partidos")
public class tb_ligas_partidos {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idtb_ligas_partidos;

@Column(name = "fecha_partido", nullable = false)
private Date fecha_partido;

@Column(name = "goles_equipo_local", nullable = false)
private int goles_equipo_local;


@Column(name = "goles_equipo_visitante", nullable = false)
private int goles_equipo_visitante;



@ManyToOne
@JoinColumn(name = "idtb_detalle_equipo_jugador", nullable = false)
private tb_detalle_equipo_jugador detalle;


@Column(name = "minuto_hora_gol", nullable = false)
private String minuto_hora_gol;


@Column(name = "descripcion_gol", nullable = false)
private String descripcion_gol;





}
