package com.jcaa.udec.collections.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jcaa.udec.collections.domain.port.out.EliminarNiñoPort;
import org.junit.jupiter.api.Test;

class EliminarNiñoServiceTest {

    @Test
    void deberiaEliminarNiñoPorMatricula() {
        EliminarNiñoPortStub eliminarNiñoPort =
                new EliminarNiñoPortStub();

        EliminarNiñoService service =
                new EliminarNiñoService(eliminarNiñoPort);

        service.eliminar("N001");

        assertThat(eliminarNiñoPort.getMatriculaEliminada())
                .isEqualTo("N001");
    }

    private static final class EliminarNiñoPortStub
            implements EliminarNiñoPort {

        private String matriculaEliminada;

        @Override
        public void eliminar(String matricula) {
            this.matriculaEliminada = matricula;
        }

        private String getMatriculaEliminada() {
            return matriculaEliminada;
        }
    }
}