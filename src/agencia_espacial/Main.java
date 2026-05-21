package agencia_espacial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Nave> naves = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n=== MENU DE GESTION DE EXPEDICIONES ESPACIALES ===");
            System.out.println("1. Agregar nave");
            System.out.println("2. Mostrar todas las naves");
            System.out.println("3. Iniciar exploraciOn");
            System.out.println("4. Mostrar naves ordenadas por nombre");
            System.out.println("5. Mostrar naves ordenadas por anio de lanzamiento (desc)");
            System.out.println("6. Mostrar naves ordenadas por tripulacion (desc)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opcion: ");
            
            String input = scanner.nextLine();
            try {
                opcion = Integer.parseInt(input);
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida. Ingrese un número.");
            }
        } while (opcion != 7);
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: agregarNave(); break;
            case 2: mostrarNaves(naves); break;
            case 3: iniciarExploracion(); break;
            case 4: ordenarPorNombre(); break;
            case 5: ordenarPorAnio(); break;
            case 6: ordenarPorTripulacion(); break;
            case 7: System.out.println("Saliendo del sistema..."); break;
            default: System.out.println("Opción no válida.");
        }
    }

    private static void agregarNave() {
        System.out.println("\nTipo de nave:");
        System.out.println("1. Nave de exploracion");
        System.out.println("2. Carguero");
        System.out.println("3. Crucero estelar");
        System.out.print("Seleccione tipo de nave: ");
        
        int tipo = Integer.parseInt(scanner.nextLine());
        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido."); // [cite: 43] Escenario 14
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        if (nombre.trim().isEmpty()) {
            System.out.println("Error: El nombre no puede estar vacío."); // [cite: 43] Escenario 12
            return;
        }

        System.out.print("Capacidad de tripulacion: ");
        int tripulacion = Integer.parseInt(scanner.nextLine());

        System.out.print("Año de lanzamiento: ");
        int anio = Integer.parseInt(scanner.nextLine());
        if (anio < 0) {
            System.out.println("Error: Año no puede ser negativo."); // [cite: 43] Escenario 11
            return;
        }

        Nave nuevaNave = null;

        switch (tipo) {
            case 1:
                System.out.println("Misiones: 1.CARTOGRAFIA 2.INVESTIGACION 3.CONTACTO");
                int opcMision = Integer.parseInt(scanner.nextLine());
                TipoMision mision = TipoMision.values()[opcMision - 1];
                nuevaNave = new NaveExploracion(nombre, tripulacion, anio, mision);
                break;
            case 2:
                System.out.print("Capacidad de carga (100 a 500): ");
                int carga = Integer.parseInt(scanner.nextLine());
                if (carga < 100 || carga > 500) {
                    System.out.println("Valor fuera de rango. Intente nuevamente."); //  Escenario 4
                    return;
                }
                nuevaNave = new Carguero(nombre, tripulacion, anio, carga);
                break;
            case 3:
                System.out.print("Cantidad de pasajeros: ");
                int pasajeros = Integer.parseInt(scanner.nextLine());
                nuevaNave = new CruceroEstelar(nombre, tripulacion, anio, pasajeros);
                break;
        }

        // Validación de duplicados usando el equals() de la clase Nave [cite: 18, 41]
        if (naves.contains(nuevaNave)) {
            System.out.println("Ya existe una nave con ese nombre y año de lanzamiento."); 
        } else {
            naves.add(nuevaNave);
            System.out.println("Nave agregada con éxito.");
        }
    }

    private static void mostrarNaves(List<Nave> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay naves registradas.");
            return;
        }
        for (Nave n : lista) {
            System.out.println(n.toString());
        }
    }

    private static void iniciarExploracion() {
        for (Nave n : naves) {
            // Usamos la interfaz Explorable para filtrar [cite: 29, 35]
            if (n instanceof Explorable) {
                ((Explorable) n).explorar();
            } else {
                System.out.println("El crucero estelar " + n.getNombre() + " no participa en exploraciones.");
            }
        }
    }

    private static void ordenarPorNombre() {
        List<Nave> copia = new ArrayList<>(naves);
        Collections.sort(copia); // Usa el compareTo natural implementado en Nave [cite: 41]
        mostrarNaves(copia);
    }

    private static void ordenarPorAnio() {
        List<Nave> copia = new ArrayList<>(naves);
        // Comparator: de más reciente a más antiguo (descendente) [cite: 41]
        copia.sort(Comparator.comparingInt(Nave::getAnioLanzamiento).reversed());
        mostrarNaves(copia);
    }

    private static void ordenarPorTripulacion() {
        List<Nave> copia = new ArrayList<>(naves);
        // Comparator: mayor capacidad a menor (descendente) [cite: 41]
        copia.sort(Comparator.comparingInt(Nave::getCapacidadTripulacion).reversed());
        mostrarNaves(copia);
    }
}