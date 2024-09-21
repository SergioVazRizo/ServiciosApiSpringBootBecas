package com.becas.becas.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "solicitud_beca")
public class SolicitudBeca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudBeca;

    @ManyToOne
    @JoinColumn(name = "becaId", nullable = false)
    private Beca beca;

    @Column(nullable = false)
    private Long alumnoId;

    @Column(nullable = false)
    private String estadoSolicitud;

    @Column(nullable = true)
    private String comentariosSolicitud;
    
}
