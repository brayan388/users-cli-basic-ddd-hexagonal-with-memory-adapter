package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ActualizarNiñoPort;

import java.util.List;

public class ActualizarNiñoAdapter implements ActualizarNiñoPort {

    private final List<Niño> niños = NiñosMemoria.obtenerNiños();

    @Override
    public void actualizar(Niño niño) {
        for (int i = 0; i < niños.size(); i++) {
            if (niños.get(i).getMatricula().equals(niño.getMatricula())) {
                niños.set(i, niño);
                return;
            }
        }

        throw new RuntimeException("El niño no existe");
    }
}