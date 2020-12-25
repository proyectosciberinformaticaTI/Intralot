package com.example.demo.dao;


import com.example.demo.model.tb_jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJugadorDao extends JpaRepository<tb_jugador,Integer> {
}
