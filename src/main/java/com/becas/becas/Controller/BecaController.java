package com.becas.becas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becas.becas.entity.Beca;
import com.becas.becas.service.BecaService;

@RestController
@RequestMapping(path = "/api/beca")
public class BecaController {
    

    @Autowired
    private BecaService becaService;

    @GetMapping("/{becaId}")
    public Beca getById(@PathVariable("becaId") Long becaId){
        return becaService.getBecas(becaId).orElse(null); // Devuelve null si no encuentra la beca, puedes ajustar esto si quieres manejar errores
    }

    @GetMapping
    public List<Beca> getAll(){
        return becaService.getBecas();
    }

    @DeleteMapping("/{becaId}")
    public void delete(@PathVariable("becaId") Long becaId){
        becaService.delete(becaId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Beca beca){
        becaService.saveOrUpdate(beca);
    }

}
