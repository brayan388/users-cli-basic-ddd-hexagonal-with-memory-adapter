package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.ports.in.BuscarNiñoUseCase;
import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ObtenerNiñosPort;

public class BuscarNiñoService implements BuscarNiñoUseCase {

    private final ObtenerNiñosPort obtenerNiñosPort;

    public BuscarNiñoService(ObtenerNiñosPort obtenerNiñosPort) {
        this.obtenerNiñosPort = obtenerNiñosPort;
    }

    @Override
    public Niño buscarPorMatricula(String matricula) {
        return obtenerNiñosPort.buscarPorMatricula(matricula);
    }
}