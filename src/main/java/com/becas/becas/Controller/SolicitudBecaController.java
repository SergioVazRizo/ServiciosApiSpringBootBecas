package com.becas.becas.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.becas.becas.entity.SolicitudBeca;
import com.becas.becas.repository.SolicitudBecaRepository;
import com.becas.becas.service.SolicitudBecaService;

@RestController
@RequestMapping(path = "/api/solicitudBeca")
public class SolicitudBecaController {
    
    @Autowired
    private SolicitudBecaService solicitudBecaService;

    @Autowired
    private SolicitudBecaRepository solicitudBecaRepository; // Inyección correcta del repositorio

    @GetMapping
    public List<SolicitudBeca> getAllSolicitudBecas(){
        return solicitudBecaService.getSolicitudes();    
    }

    @GetMapping("/{idSolicitudBeca}")
    public SolicitudBeca gSolicitudBecaById(@PathVariable Long idSolicitudBeca){
        return solicitudBecaService.getSolicitudes(idSolicitudBeca).orElse(null);
    }
    
    @PostMapping
    public void seveOrUpdateSolicitud(@RequestBody SolicitudBeca solicitudBeca){
        solicitudBecaService.sevaOrUpdate(solicitudBeca);
    }

    @DeleteMapping("/{idSolicitudBeca}")
    public void deleteSolicitud(@PathVariable Long idSolicitudBeca){
        solicitudBecaService.delete(idSolicitudBeca);
    }

    @PutMapping("/{idSolicitudBeca}")
    public SolicitudBeca updateSolicitudBeca(
            @PathVariable Long idSolicitudBeca, 
            @RequestBody Map<String, String> updates) {
        
        SolicitudBeca solicitudBeca = solicitudBecaService.getSolicitudes(idSolicitudBeca).orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        if (updates.containsKey("estadoSolicitud")) {
            solicitudBeca.setEstadoSolicitud(updates.get("estadoSolicitud"));
        }

        if (updates.containsKey("comentariosSolicitud")) {
            solicitudBeca.setComentariosSolicitud(updates.get("comentariosSolicitud"));
        }

        solicitudBecaService.sevaOrUpdate(solicitudBeca);

        return solicitudBeca;
    }

    @GetMapping("/existe")
    public ResponseEntity<Map<String, Boolean>> existeSolicitud(
            @RequestParam Long becaId, 
            @RequestParam Long alumnoId) {
        
        // Aquí usas la instancia del repositorio inyectada correctamente
        boolean existe = solicitudBecaRepository.existsByBecaBecaIdAndAlumnoId(becaId, alumnoId);

        // Devolvemos la respuesta como un JSON
        Map<String, Boolean> response = new HashMap<>();
        response.put("registrado", existe);
        return ResponseEntity.ok(response);
    }
}
