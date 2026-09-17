package com.jcaa.udec.collections.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ObtenerNiñosPort;
import org.junit.jupiter.api.Test;

class BuscarNiñoServiceTest {

    @Test
    void deberiaBuscarNiñoPorMatricula() {
        Niño niño = Niño.builder()
                .matricula("N001")
                .nombre("Juan Perez")
                .fechaNacimiento("2018-05-10")
                .fechaIngreso("2026-09-01")
                .fechaBaja(null)
                .build();

        ObtenerNiñosPortStub obtenerNiñosPort =
                new ObtenerNiñosPortStub(niño);

        BuscarNiñoService service =
                new BuscarNiñoService(obtenerNiñosPort);

        Niño resultado = service.buscarPorMatricula("N001");

        assertThat(resultado.getMatricula()).isEqualTo("N001");
        assertThat(resultado.getNombre()).isEqualTo("Juan Perez");
    }

    private static final class ObtenerNiñosPortStub
            implements ObtenerNiñosPort {

        private final Niño niño;

        private ObtenerNiñosPortStub(Niño niño) {
            this.niño = niño;
        }

        @Override
        public java.util.List<Niño> obtenerTodos() {
            return java.util.List.of(niño);
        }

        @Override
        public Niño buscarPorMatricula(String matricula) {
            if (niño.getMatricula().equals(matricula)) {
                return niño;
            }
            return null;
        }
    }
}