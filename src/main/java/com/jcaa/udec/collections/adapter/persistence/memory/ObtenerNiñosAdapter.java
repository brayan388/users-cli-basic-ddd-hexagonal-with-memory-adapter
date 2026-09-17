package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ObtenerNiñosPort;

import java.util.List;
import java.util.Objects;

public class ObtenerNiñosAdapter implements ObtenerNiñosPort {

    private final List<Niño> niños = NiñosMemoria.obtenerNiños();

    @Override
    public List<Niño> obtenerTodos() {
        return List.copyOf(niños);
    }

    @Override
    public Niño buscarPorMatricula(String matricula) {
        for (Niño niño : niños) {
            if (Objects.equals(niño.getMatricula(), matricula)) {
                return niño;
            }
        }

        throw new RuntimeException("El niño no existe");
    }
}