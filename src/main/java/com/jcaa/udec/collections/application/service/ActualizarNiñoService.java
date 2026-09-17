package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.command.CrearNiñoComando;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarNiñoUseCase;
import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ActualizarNiñoPort;

public class ActualizarNiñoService implements ActualizarNiñoUseCase {

    private final ActualizarNiñoPort actualizarNiñoPort;

    public ActualizarNiñoService(ActualizarNiñoPort actualizarNiñoPort) {
        this.actualizarNiñoPort = actualizarNiñoPort;
    }

    @Override
    public void actualizar(CrearNiñoComando comando) {
        Niño niño = Niño.builder()
                .matricula(comando.matricula())
                .nombre(comando.nombre())
                .fechaNacimiento(comando.fechaNacimiento())
                .fechaIngreso(comando.fechaIngreso())
                .fechaBaja(comando.fechaBaja())
                .build();

        actualizarNiñoPort.actualizar(niño);
    }
}