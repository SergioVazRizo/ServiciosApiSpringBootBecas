package com.becas.becas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.becas.becas.entity.Beca;

@Repository
public interface BecaRepository extends JpaRepository<Beca, Long> {
    
}
