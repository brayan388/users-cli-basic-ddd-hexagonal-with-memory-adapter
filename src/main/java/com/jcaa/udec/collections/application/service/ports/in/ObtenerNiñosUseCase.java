package com.jcaa.udec.collections.application.service.ports.in;

import com.jcaa.udec.collections.domain.core.model.Niño;

import java.util.List;

public interface ObtenerNiñosUseCase {

    List<Niño> obtenerTodos();
}