package com.jcaa.udec.collections.application.service.ports.in;

import com.jcaa.udec.collections.application.service.dto.command.CrearNiñoComando;

public interface CrearNiñoUseCase {

    void crear(CrearNiñoComando comando);
}