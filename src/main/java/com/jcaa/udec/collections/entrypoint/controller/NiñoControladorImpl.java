package com.jcaa.udec.collections.entrypoint.controller;

import com.jcaa.udec.collections.application.service.dto.command.CrearNiñoComando;
import com.jcaa.udec.collections.application.service.ports.in.ActualizarNiñoUseCase;
import com.jcaa.udec.collections.application.service.ports.in.BuscarNiñoUseCase;
import com.jcaa.udec.collections.application.service.ports.in.CrearNiñoUseCase;
import com.jcaa.udec.collections.application.service.ports.in.EliminarNiñoUseCase;
import com.jcaa.udec.collections.application.service.ports.in.ObtenerNiñosUseCase;
import com.jcaa.udec.collections.domain.core.model.Niño;

import java.util.List;

public class NiñoControladorImpl implements NiñoControlador {

    private final CrearNiñoUseCase crearNiñoUseCase;
    private final BuscarNiñoUseCase buscarNiñoUseCase;
    private final ObtenerNiñosUseCase obtenerNiñosUseCase;
    private final ActualizarNiñoUseCase actualizarNiñoUseCase;
    private final EliminarNiñoUseCase eliminarNiñoUseCase;

    public NiñoControladorImpl(
            CrearNiñoUseCase crearNiñoUseCase,
            BuscarNiñoUseCase buscarNiñoUseCase,
            ObtenerNiñosUseCase obtenerNiñosUseCase,
            ActualizarNiñoUseCase actualizarNiñoUseCase,
            EliminarNiñoUseCase eliminarNiñoUseCase) {

        this.crearNiñoUseCase = crearNiñoUseCase;
        this.buscarNiñoUseCase = buscarNiñoUseCase;
        this.obtenerNiñosUseCase = obtenerNiñosUseCase;
        this.actualizarNiñoUseCase = actualizarNiñoUseCase;
        this.eliminarNiñoUseCase = eliminarNiñoUseCase;
    }

    @Override
    public void crear(
            String matricula,
            String nombre,
            String fechaNacimiento,
            String fechaIngreso,
            String fechaBaja) {

        CrearNiñoComando comando = new CrearNiñoComando(
                matricula,
                nombre,
                fechaNacimiento,
                fechaIngreso,
                fechaBaja);

        crearNiñoUseCase.crear(comando);
    }

    @Override
    public Niño buscarPorMatricula(String matricula) {
        return buscarNiñoUseCase.buscarPorMatricula(matricula);
    }

    @Override
    public List<Niño> obtenerTodos() {
        return obtenerNiñosUseCase.obtenerTodos();
    }

    @Override
    public void actualizar(
            String matricula,
            String nombre,
            String fechaNacimiento,
            String fechaIngreso,
            String fechaBaja) {

        CrearNiñoComando comando = new CrearNiñoComando(
                matricula,
                nombre,
                fechaNacimiento,
                fechaIngreso,
                fechaBaja);

        actualizarNiñoUseCase.actualizar(comando);
    }

    @Override
    public void eliminar(String matricula) {
        eliminarNiñoUseCase.eliminar(matricula);
    }
}