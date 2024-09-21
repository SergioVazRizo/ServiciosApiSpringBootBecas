package com.becas.becas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becas.becas.entity.SolicitudBeca;

@Repository
public interface SolicitudBecaRepository extends JpaRepository<SolicitudBeca, Long> {

    
}
