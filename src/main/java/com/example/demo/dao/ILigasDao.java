package com.example.demo.dao;


import com.example.demo.model.tb_ligas_partidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILigasDao extends JpaRepository<tb_ligas_partidos,Integer> {
}
