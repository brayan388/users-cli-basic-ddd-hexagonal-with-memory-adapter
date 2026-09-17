package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.ports.in.EliminarNiñoUseCase;
import com.jcaa.udec.collections.domain.port.out.EliminarNiñoPort;

public class EliminarNiñoService implements EliminarNiñoUseCase {

    private final EliminarNiñoPort eliminarNiñoPort;

    public EliminarNiñoService(EliminarNiñoPort eliminarNiñoPort) {
        this.eliminarNiñoPort = eliminarNiñoPort;
    }

    @Override
    public void eliminar(String matricula) {
        eliminarNiñoPort.eliminar(matricula);
    }
}