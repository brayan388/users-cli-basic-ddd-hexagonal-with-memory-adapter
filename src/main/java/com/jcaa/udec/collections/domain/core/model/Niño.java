package com.jcaa.udec.collections.domain.core.model;

import lombok.Builder;

public class Niño {

    private final String matricula;
    private final String nombre;
    private final String fechaNacimiento;
    private final String fechaIngreso;
    private final String fechaBaja;

    @Builder
    public Niño(
            String matricula,
            String nombre,
            String fechaNacimiento,
            String fechaIngreso,
            String fechaBaja) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaBaja = fechaBaja;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }
}