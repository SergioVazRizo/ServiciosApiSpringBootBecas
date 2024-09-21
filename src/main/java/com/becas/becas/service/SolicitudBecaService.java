package com.becas.becas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becas.becas.entity.SolicitudBeca;
import com.becas.becas.repository.SolicitudBecaRepository;

@Service
public class SolicitudBecaService {
    
    @Autowired
    SolicitudBecaRepository solicitudBecaRepository;

    public List<SolicitudBeca> getSolicitudes(){return solicitudBecaRepository.findAll();}

    public Optional<SolicitudBeca> getSolicitudes(Long idSolicitudBeca){return solicitudBecaRepository.findById(idSolicitudBeca);}

    public void sevaOrUpdate(SolicitudBeca solicitudBeca){solicitudBecaRepository.save(solicitudBeca);}

    public void delete(Long idSolicitudBeca){solicitudBecaRepository.deleteById(idSolicitudBeca);}
}
