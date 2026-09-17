package com.jcaa.udec.collections.domain.port.out;

import com.jcaa.udec.collections.domain.core.model.Niño;

import java.util.List;

public interface ObtenerNiñosPort {

    List<Niño> obtenerTodos();

    Niño buscarPorMatricula(String matricula);
}