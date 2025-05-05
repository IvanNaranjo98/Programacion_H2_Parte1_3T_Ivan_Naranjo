package cine;
import java.sql.Connection; // Para conectar con la base de datos.
import java.sql.ResultSet; // Para guardar los datos que nos devuelve la base de datos.
import java.sql.Statement; // Para enviar consultas a la base de datos.

public class PeliculaDB { // Creo una clase que se llama PeliculaDB.
    public void mostrarPeliculas() { // Este método sirve para mostrar las películas.
        Connection conn = DatabaseConnection.getConnection(); // Pedimos la conexión a la base de datos usando la clase DatabaseConnection.
        if (conn == null) { // Si no se pudo conectar...
            return; // Nos salimos del método, no hacemos nada.
        }

        try { // Intentamos hacer lo siguiente...
            // Creamos un "Statement" para enviar una consulta a la base de datos.
            Statement stmt = conn.createStatement();
            // Esta consulta pide el código, título y género de las películas, juntando las tablas peliculas y generos.
            ResultSet rs = stmt.executeQuery(
                "SELECT p.codigo_pelicula, p.titulo, g.nombre " + "FROM peliculas p JOIN generos g ON p.id_genero = g.id_genero"
            );

            // Mientras haya datos en el resultado...
            while (rs.next()) {
                // Mostramos el código, título y género de cada película.
                System.out.println(
                    rs.getString("codigo_pelicula") + " " + rs.getString("titulo") + " " + rs.getString("nombre")
                );
            }

            // Cerramos todo para no dejar cosas abiertas.
            rs.close(); // Cerramos el resultado.
            stmt.close(); // Cerramos el Statement.
            conn.close(); // Cerramos la conexión.

        } catch (Exception e) { // Si algo falla como un error en la consulta...
            System.out.println("Error al mostrar películas"); // Mostramos un mensaje de error.
        }
    }
}
