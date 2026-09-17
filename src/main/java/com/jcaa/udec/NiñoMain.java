package com.jcaa.udec;

import com.jcaa.udec.collections.adapter.persistence.memory.ActualizarNiñoAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.EliminarNiñoAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.GuardarNiñoAdapter;
import com.jcaa.udec.collections.adapter.persistence.memory.ObtenerNiñosAdapter;
import com.jcaa.udec.collections.application.service.ActualizarNiñoService;
import com.jcaa.udec.collections.application.service.BuscarNiñoService;
import com.jcaa.udec.collections.application.service.CrearNiñoService;
import com.jcaa.udec.collections.application.service.EliminarNiñoService;
import com.jcaa.udec.collections.application.service.ObtenerNiñosService;
import com.jcaa.udec.collections.entrypoint.cli.NiñoGuiCli;
import com.jcaa.udec.collections.entrypoint.controller.NiñoControlador;
import com.jcaa.udec.collections.entrypoint.controller.NiñoControladorImpl;

public class NiñoMain {

    public static void main(String[] args) {

        var crearNiñoService =
                new CrearNiñoService(new GuardarNiñoAdapter());

        var buscarNiñoService =
                new BuscarNiñoService(new ObtenerNiñosAdapter());

        var obtenerNiñosService =
                new ObtenerNiñosService(new ObtenerNiñosAdapter());

        var actualizarNiñoService =
                new ActualizarNiñoService(new ActualizarNiñoAdapter());

        var eliminarNiñoService =
                new EliminarNiñoService(new EliminarNiñoAdapter());

        NiñoControlador controlador = new NiñoControladorImpl(
                crearNiñoService,
                buscarNiñoService,
                obtenerNiñosService,
                actualizarNiñoService,
                eliminarNiñoService);

        new NiñoGuiCli(controlador).ejecutarAccion();
    }
}