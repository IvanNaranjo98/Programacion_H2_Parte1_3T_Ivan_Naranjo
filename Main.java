package cine;
import java.util.Scanner; // Para leer lo que el usuario escribe en la consola.

public class Main { // Esta es la clase principal, donde empieza el programa.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creo un Scanner para leer lo que el usuario escribe.
        PeliculaDB peliculaDB = new PeliculaDB(); // Creo un objeto de la clase PeliculaDB para usar sus funciones.

        while (true) {
            // Mostramos un menú con opciones.
            System.out.println("1 - Ver Películas");
            System.out.println("2 - Salir");
            System.out.print("Opción: ");

            String opcion = scanner.nextLine(); // Guardamos lo que el usuario escribe.

            if (opcion.equals("1")) { // Si el usuario escribe "1"...
                peliculaDB.mostrarPeliculas(); // Llamamos al método que muestra las películas.
            } else if (opcion.equals("2")) { // Si escribe "2"...
                System.out.println("¡Adiós!"); // Mostramos un mensaje de despedida.
                break; // Salimos del bucle el programa termina.
            } else { // Si escribe cualquier otra cosa...
                System.out.println("Opción no válida"); // Le decimos que no es una opción correcta.
            }
        }
        scanner.close(); // Cerramos el Scanner para no dejarlo abierto.
    }
}
