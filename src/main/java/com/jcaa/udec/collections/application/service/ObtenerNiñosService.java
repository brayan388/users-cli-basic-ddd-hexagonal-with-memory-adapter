package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.ports.in.ObtenerNiñosUseCase;
import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ObtenerNiñosPort;

import java.util.List;

public class ObtenerNiñosService implements ObtenerNiñosUseCase {

    private final ObtenerNiñosPort obtenerNiñosPort;

    public ObtenerNiñosService(ObtenerNiñosPort obtenerNiñosPort) {
        this.obtenerNiñosPort = obtenerNiñosPort;
    }

    @Override
    public List<Niño> obtenerTodos() {
        return obtenerNiñosPort.obtenerTodos();
    }
}