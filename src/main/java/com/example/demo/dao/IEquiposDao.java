package com.example.demo.dao;


import com.example.demo.model.tb_equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEquiposDao extends JpaRepository<tb_equipo,Integer> {
}
