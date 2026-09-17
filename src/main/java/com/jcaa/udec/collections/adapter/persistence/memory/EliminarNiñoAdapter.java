package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.port.out.EliminarNiñoPort;

import java.util.List;

public class EliminarNiñoAdapter implements EliminarNiñoPort {

    private final List<com.jcaa.udec.collections.domain.core.model.Niño> niños =
            NiñosMemoria.obtenerNiños();

    @Override
    public void eliminar(String matricula) {
        niños.removeIf(niño -> niño.getMatricula().equals(matricula));
    }
}