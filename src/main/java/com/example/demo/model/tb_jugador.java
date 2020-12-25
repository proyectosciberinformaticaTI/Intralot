package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tb_jugador")
public class tb_jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtb_jugador")
    private int idtb_jugador;


    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fecha_nacimiento;



    @Column(name = "posicion", nullable = false)
    private String posicion;




   // @JsonIgnoreProperties(value = {"preguntas"})
 //   @ManyToOne(fetch = FetchType.LAZY)
 //   private tb_equipo equipo;

}
