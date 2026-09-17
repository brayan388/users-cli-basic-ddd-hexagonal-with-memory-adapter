package com.jcaa.udec.collections.application.service.dto.command;

public record CrearNiñoComando(
        String matricula,
        String nombre,
        String fechaNacimiento,
        String fechaIngreso,
        String fechaBaja
) {}