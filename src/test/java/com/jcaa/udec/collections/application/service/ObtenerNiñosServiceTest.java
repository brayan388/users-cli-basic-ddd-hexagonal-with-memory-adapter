package com.jcaa.udec.collections.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.domain.port.out.ObtenerNiñosPort;
import java.util.List;
import org.junit.jupiter.api.Test;

class ObtenerNiñosServiceTest {

  @Test
  void deberiaObtenerTodosLosNiños() {
    // Arrange
    Niño niño = Niño.builder()
        .matricula("N001")
        .nombre("Juan Perez")
        .fechaNacimiento("2018-05-10")
        .fechaIngreso("2026-09-01")
        .fechaBaja(null)
        .build();

    ObtenerNiñosPortStub obtenerNiñosPort =
        new ObtenerNiñosPortStub(List.of(niño));

    ObtenerNiñosService service =
        new ObtenerNiñosService(obtenerNiñosPort);

    // Act
    List<Niño> resultado = service.obtenerTodos();

    // Assert
    assertThat(resultado)
        .singleElement()
        .extracting(Niño::getMatricula, Niño::getNombre)
        .containsExactly("N001", "Juan Perez");
  }

  private static final class ObtenerNiñosPortStub
      implements ObtenerNiñosPort {

    private final List<Niño> niños;

    private ObtenerNiñosPortStub(List<Niño> niños) {
      this.niños = niños;
    }

    @Override
    public List<Niño> obtenerTodos() {
      return niños;
    }

    @Override
    public Niño buscarPorMatricula(String matricula) {
      return niños.stream()
          .filter(niño -> niño.getMatricula().equals(matricula))
          .findFirst()
          .orElse(null);
    }
  }
}