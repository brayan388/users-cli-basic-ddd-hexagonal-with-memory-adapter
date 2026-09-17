package com.jcaa.udec.collections.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jcaa.udec.collections.application.service.dto.command.CrearNiñoComando;
import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.GuardarNiñoPort;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CrearNiñoServiceTest {

  private static final String MATRICULA = "N001";
  private static final String NOMBRE = "Juan Perez";
  private static final String FECHA_NACIMIENTO = "2018-05-10";
  private static final String FECHA_INGRESO = "2026-09-01";
  private static final String FECHA_BAJA = null;

  @Test
  void deberiaMapearYGuardarNiño() {
    // Arrange
    GuardarNiñoPortStub guardarNiñoPort = new GuardarNiñoPortStub();
    CrearNiñoService service = new CrearNiñoService(guardarNiñoPort);
    CrearNiñoComando comando =
        new CrearNiñoComando(
            MATRICULA,
            NOMBRE,
            FECHA_NACIMIENTO,
            FECHA_INGRESO,
            FECHA_BAJA);

    // Act
    service.crear(comando);

    // Assert
    assertThat(guardarNiñoPort.getNiñosGuardados())
        .singleElement()
        .extracting(
            Niño::getMatricula,
            Niño::getNombre,
            Niño::getFechaNacimiento,
            Niño::getFechaIngreso,
            Niño::getFechaBaja)
        .containsExactly(
            MATRICULA,
            NOMBRE,
            FECHA_NACIMIENTO,
            FECHA_INGRESO,
            FECHA_BAJA);
  }

  private static final class GuardarNiñoPortStub implements GuardarNiñoPort {

    private final List<Niño> niñosGuardados = new ArrayList<>();

    @Override
    public void guardar(Niño niño) {
      niñosGuardados.add(niño);
    }

    private List<Niño> getNiñosGuardados() {
      return List.copyOf(niñosGuardados);
    }
  }
}