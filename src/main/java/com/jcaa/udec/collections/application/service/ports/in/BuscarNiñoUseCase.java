package com.jcaa.udec.collections.application.service.ports.in;

import com.jcaa.udec.collections.domain.core.model.Niño;

public interface BuscarNiñoUseCase {
    Niño buscarPorMatricula(String matricula);
}