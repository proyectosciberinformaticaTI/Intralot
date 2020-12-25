package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "tb_equipo")
public class tb_equipo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int  idtb_equipo;

  @Column(name = "nombre_equipo", nullable = false)
  private String nombre_equipo;

  @Column(name = "nombre_estadio", nullable = false)
  private String nombre_estadio;

  @Column(name = "aforo", nullable = false)
  private Integer aforo;

  @Column(name = "año_fundacion", nullable = false)
  private Date año_fundacion;

  @Column(name = "ciudad", nullable = false)
  private String ciudad;


 // @OneToMany(mappedBy = "idtb_jugador", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
  //        CascadeType.REMOVE }, fetch = FetchType.LAZY)
 // private List<tb_jugador> jugador;
}
