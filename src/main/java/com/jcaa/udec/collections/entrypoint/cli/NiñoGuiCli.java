package com.jcaa.udec.collections.entrypoint.cli;

import com.jcaa.udec.collections.domain.core.model.Niño;
import com.jcaa.udec.collections.entrypoint.controller.NiñoControlador;

import java.util.Scanner;

public class NiñoGuiCli {

    private final NiñoControlador niñoControlador;
    private final Scanner entrada;

    public NiñoGuiCli(NiñoControlador niñoControlador) {
        this.niñoControlador = niñoControlador;
        this.entrada = new Scanner(System.in);
    }

    public void ejecutarAccion() {
        int opcion;

        do {
            mostrarMenu();
            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1 -> crearNiño();
                case 2 -> buscarNiño();
                case 3 -> listarNiños();
                case 4 -> actualizarNiño();
                case 5 -> eliminarNiño();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 6);
    }

    private void mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE NIÑOS ===");
        System.out.println("1. Crear niño");
        System.out.println("2. Buscar niño");
        System.out.println("3. Listar niños");
        System.out.println("4. Actualizar niño");
        System.out.println("5. Eliminar niño");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void crearNiño() {
        System.out.println("\n=== CREAR NIÑO ===");

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = entrada.nextLine();

        System.out.print("Fecha de ingreso (YYYY-MM-DD): ");
        String fechaIngreso = entrada.nextLine();

        System.out.print("Fecha de baja (YYYY-MM-DD, opcional): ");
        String fechaBaja = entrada.nextLine();

        if (fechaBaja.isBlank()) {
            fechaBaja = null;
        }

        niñoControlador.crear(
                matricula,
                nombre,
                fechaNacimiento,
                fechaIngreso,
                fechaBaja);

        System.out.println("Niño creado correctamente.");
    }

    private void buscarNiño() {
        System.out.println("\n=== BUSCAR NIÑO ===");

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        Niño niño = niñoControlador.buscarPorMatricula(matricula);

        System.out.println("Matrícula: " + niño.getMatricula());
        System.out.println("Nombre: " + niño.getNombre());
        System.out.println("Fecha de nacimiento: " + niño.getFechaNacimiento());
        System.out.println("Fecha de ingreso: " + niño.getFechaIngreso());
        System.out.println("Fecha de baja: " + niño.getFechaBaja());
    }

    private void listarNiños() {
        System.out.println("\n=== LISTA DE NIÑOS ===");

        var niños = niñoControlador.obtenerTodos();

        if (niños.isEmpty()) {
            System.out.println("No hay niños registrados.");
            return;
        }

        for (Niño niño : niños) {
            System.out.println("--------------------");
            System.out.println("Matrícula: " + niño.getMatricula());
            System.out.println("Nombre: " + niño.getNombre());
            System.out.println("Fecha de nacimiento: " + niño.getFechaNacimiento());
            System.out.println("Fecha de ingreso: " + niño.getFechaIngreso());
            System.out.println("Fecha de baja: " + niño.getFechaBaja());
        }
    }

    private void actualizarNiño() {
        System.out.println("\n=== ACTUALIZAR NIÑO ===");

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = entrada.nextLine();

        System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
        String fechaNacimiento = entrada.nextLine();

        System.out.print("Nueva fecha de ingreso (YYYY-MM-DD): ");
        String fechaIngreso = entrada.nextLine();

        System.out.print("Nueva fecha de baja (YYYY-MM-DD, opcional): ");
        String fechaBaja = entrada.nextLine();

        if (fechaBaja.isBlank()) {
            fechaBaja = null;
        }

        niñoControlador.actualizar(
                matricula,
                nombre,
                fechaNacimiento,
                fechaIngreso,
                fechaBaja);

        System.out.println("Niño actualizado correctamente.");
    }

    private void eliminarNiño() {
        System.out.println("\n=== ELIMINAR NIÑO ===");

        System.out.print("Matrícula: ");
        String matricula = entrada.nextLine();

        niñoControlador.eliminar(matricula);

        System.out.println("Niño eliminado correctamente.");
    }
}