package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.GuardarNiñoPort;

import java.util.List;
import java.util.Objects;

public class GuardarNiñoAdapter implements GuardarNiñoPort {

    private final List<Niño> niños = NiñosMemoria.obtenerNiños();

    @Override
    public void guardar(Niño niño) {
        for (Niño niñoRegistrado : niños) {
            if (Objects.equals(niñoRegistrado.getMatricula(), niño.getMatricula())) {
                throw new RuntimeException("El niño ya existe");
            }
        }

        niños.add(niño);
    }
}