package com.jcaa.udec.collections.entrypoint.controller;

import com.jcaa.udec.collections.domain.core.model.Niño;
import java.util.List;

public interface NiñoControlador {

    void crear(
            String matricula,
            String nombre,
            String fechaNacimiento,
            String fechaIngreso,
            String fechaBaja);

    Niño buscarPorMatricula(String matricula);

    List<Niño> obtenerTodos();

    void actualizar(
            String matricula,
            String nombre,
            String fechaNacimiento,
            String fechaIngreso,
            String fechaBaja);

    void eliminar(String matricula);
}