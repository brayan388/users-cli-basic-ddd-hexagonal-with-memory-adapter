package com.jcaa.udec.collections.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jcaa.udec.collections.application.service.dto.command.CrearNiñoComando;
import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ActualizarNiñoPort;
import org.junit.jupiter.api.Test;

class ActualizarNiñoServiceTest {

    @Test
    void deberiaActualizarNiño() {
        ActualizarNiñoPortStub actualizarNiñoPort =
                new ActualizarNiñoPortStub();

        ActualizarNiñoService service =
                new ActualizarNiñoService(actualizarNiñoPort);

        CrearNiñoComando comando =
                new CrearNiñoComando(
                        "N001",
                        "Juan Perez Actualizado",
                        "2018-05-10",
                        "2026-09-01",
                        null);

        service.actualizar(comando);

        assertThat(actualizarNiñoPort.getNiñoActualizado())
                .isNotNull()
                .extracting(Niño::getMatricula, Niño::getNombre)
                .containsExactly("N001", "Juan Perez Actualizado");
    }

    private static final class ActualizarNiñoPortStub
            implements ActualizarNiñoPort {

        private Niño niñoActualizado;

        @Override
        public void actualizar(Niño niño) {
            this.niñoActualizado = niño;
        }

        private Niño getNiñoActualizado() {
            return niñoActualizado;
        }
    }
}