package com.becas.becas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becas.becas.entity.Beca;
import com.becas.becas.repository.BecaRepository;

@Service
public class BecaService {
    
    @Autowired
    BecaRepository becaRepository;

    public List<Beca> getBecas(){ return becaRepository.findAll();}

    public Optional<Beca> getBecas(Long becaId){ return becaRepository.findById(becaId);}
 
    public void saveOrUpdate(Beca beca){ becaRepository.save(beca);}

    public void delete(Long id){ becaRepository.deleteById(id);}

}
