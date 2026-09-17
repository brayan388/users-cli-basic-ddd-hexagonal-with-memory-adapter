package com.jcaa.udec.collections.application.service;

import com.jcaa.udec.collections.application.service.dto.command.CrearNiñoComando;
import com.jcaa.udec.collections.application.service.ports.in.CrearNiñoUseCase;
import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.GuardarNiñoPort;

public class CrearNiñoService implements CrearNiñoUseCase {

    private final GuardarNiñoPort guardarNiñoPort;

    public CrearNiñoService(GuardarNiñoPort guardarNiñoPort) {
        this.guardarNiñoPort = guardarNiñoPort;
    }

    @Override
    public void crear(CrearNiñoComando comando) {
        Niño niño = Niño.builder()
                .matricula(comando.matricula())
                .nombre(comando.nombre())
                .fechaNacimiento(comando.fechaNacimiento())
                .fechaIngreso(comando.fechaIngreso())
                .fechaBaja(comando.fechaBaja())
                .build();

        guardarNiñoPort.guardar(niño);
    }
}