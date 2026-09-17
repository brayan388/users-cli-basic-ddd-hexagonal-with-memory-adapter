package com.jcaa.udec.collections.adapter.persistence.memory;

import com.jcaa.udec.collections.domain.core.model.Niño;

import java.util.ArrayList;
import java.util.List;

final class NiñosMemoria {

    private static final List<Niño> NIÑOS = new ArrayList<>();

    private NiñosMemoria() {
    }

    static List<Niño> obtenerNiños() {
        return NIÑOS;
    }
}