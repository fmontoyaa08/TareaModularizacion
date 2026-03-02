package introduccion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEstudiantes {

    // PARTE 1: VARIABLES GLOBALES (Atributos static)
    // Se declaran aquí para que todos los métodos puedan acceder a ellas.
    static List<String> estudiantes = new ArrayList<>();
    static List<Double> calificaciones = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de estudiantes.");

        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

            // PARTE 2: MODULARIZACIÓN
            // El main solo coordina, no ejecuta la lógica pesada.
            switch (opcion) {
                case 1: agregarEstudiante(); break;
                case 2: mostrarLista(); break;
                case 3: calcularPromedio(); break;
                case 4: mostrarMejorEstudiante(); break;
                case 5: 
                    System.out.println("Saliendo del sistema...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    // --- MÉTODOS MODULARES (Una responsabilidad por método) ---

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ DE GESTIÓN ---");
        System.out.println("1. Agregar estudiante");
        System.out.println("2. Mostrar lista");
        System.out.println("3. Calcular promedio");
        System.out.println("4. Estudiante con nota más alta");
        System.out.println("5. Salir");
    }

    public static void agregarEstudiante() {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        // PARTE 3: VALIDACIÓN Y MANEJO DE EXCEPCIONES
        double calificacion = leerDouble("Ingrese la calificación (0-100): ");
        
        if (calificacion >= 0 && calificacion <= 100) {
            estudiantes.add(nombre);
            calificaciones.add(calificacion);
            System.out.println("Estudiante agregado.");
        } else {
            System.out.println("Error: La calificación debe estar entre 0 y 100.");
        }
    }

    public static void mostrarLista() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay datos registrados.");
            return;
        }
        System.out.println("\nLista de Estudiantes:");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i) + " - Nota: " + calificaciones.get(i));
        }
    }

    public static void calcularPromedio() {
        if (calificaciones.isEmpty()) {
            System.out.println("No hay calificaciones.");
            return;
        }
        double suma = 0;
        for (double c : calificaciones) suma += c;
        System.out.println("Promedio general: " + (suma / calificaciones.size()));
    }

    public static void mostrarMejorEstudiante() {
        if (calificaciones.isEmpty()) return;
        
        double max = calificaciones.get(0);
        int indice = 0;
        for (int i = 1; i < calificaciones.size(); i++) {
            if (calificaciones.get(i) > max) {
                max = calificaciones.get(i);
                indice = i;
            }
        }
        System.out.println("Mejor estudiante: " + estudiantes.get(indice) + " (" + max + ")");
    }

    // MÉTODOS DE APOYO PARA VALIDAR ENTRADAS
    
    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número entero válido.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese una calificación numérica válida.");
            }
        }
    }
}
