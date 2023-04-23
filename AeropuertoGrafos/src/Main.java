import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {
    public static void main(String[] args) {
        GrafoAeropuertos grafo = new GrafoAeropuertos();

        // aeropuertos
        grafo.agregarAeropuerto("Aeropuerto Internacional de la Ciudad de México");
        grafo.agregarAeropuerto("Aeropuerto Internacional de Los Ángeles");
        grafo.agregarAeropuerto("Aeropuerto Internacional de Miami");
        grafo.agregarAeropuerto("Aeropuerto Internacional de Nueva York-JFK");
        grafo.agregarAeropuerto("Aeropuerto Internacional de Toronto-Pearson");
        grafo.agregarAeropuerto("Aeropuerto Internacional de Madrid-Barajas");
        grafo.agregarAeropuerto("Aeropuerto Internacional de París-Charles de Gaulle");

        //conexiones
        grafo.agregarConexion("Aeropuerto Internacional de la Ciudad de México", "Aeropuerto Internacional de Los Ángeles", 2707);
        grafo.agregarConexion("Aeropuerto Internacional de Los Ángeles", "Aeropuerto Internacional de Miami", 3754);
        grafo.agregarConexion("Aeropuerto Internacional de Miami", "Aeropuerto Internacional de Nueva York-JFK", 1760);
        grafo.agregarConexion("Aeropuerto Internacional de Nueva York-JFK", "Aeropuerto Internacional de Toronto-Pearson", 551);
        grafo.agregarConexion("Aeropuerto Internacional de Toronto-Pearson", "Aeropuerto Internacional de Madrid-Barajas", 5957);
        grafo.agregarConexion("Aeropuerto Internacional de Madrid-Barajas", "Aeropuerto Internacional de París-Charles de Gaulle", 1059);
        grafo.agregarConexion("Aeropuerto Internacional de Nueva York-JFK", "Aeropuerto Internacional de Madrid-Barajas", 5839);

        System.out.println("====================================||DISTANCIA||====================================");
        System.out.println("Distancia entre Nueva York-JFK y Madrid-Barajas: " + grafo.obtenerDistancia("Aeropuerto Internacional de Nueva York-JFK", "Aeropuerto Internacional de Madrid-Barajas"));
        System.out.println("Distancia entre Los Ángeles y Miami: " + grafo.obtenerDistancia("Aeropuerto Internacional de Los Ángeles", "Aeropuerto Internacional de Miami"));
        System.out.println("Distancia entre Nueva York-JFK y Toronto-Pearson: " + grafo.obtenerDistancia("Aeropuerto Internacional de Nueva York-JFK", "Aeropuerto Internacional de Toronto-Pearson"));
        System.out.println("Distancia entre Ciudad de México y París-Charles de Gaulle: " + grafo.obtenerDistancia("Aeropuerto Internacional de la Ciudad de México", "Aeropuerto Internacional de París-Charles de Gaulle"));
        System.out.println(" ");
        System.out.println("====================================||CONEXIONES||====================================");
        System.out.println("Tienen conexión Nueva York-JFK y Madrid-Barajas: " + ((grafo.tienenConexion("Aeropuerto Internacional de Nueva York-JFK", "Aeropuerto Internacional de Madrid-Barajas"))? "Si" : "No"));
        System.out.println("Tienen conexión Los Ángeles y Toronto-Pearson: " + ((grafo.tienenConexion("Aeropuerto Internacional de Los Ángeles", "Aeropuerto Internacional de Toronto-Pearson"))? "Si" : "No"));
        System.out.println("Tienen conexión Ciudad de México y Miami: " + ((grafo.tienenConexion("Aeropuerto Internacional de la Ciudad de México", "Aeropuerto Internacional de Miami"))? "Si" : "No"));
        System.out.println("Tienen conexión Toronto-Pearson y París-Charles de Gaulle: " + ((grafo.tienenConexion("Aeropuerto Internacional de Toronto-Pearson", "Aeropuerto Internacional de París-Charles de Gaulle"))? "Si" : "No"));
        System.out.println("Tienen conexión Madrid-Barajas y Miami: " + ((grafo.tienenConexion("Aeropuerto Internacional de Madrid-Barajas", "Aeropuerto Internacional de Miami"))? "Si" : "No"));

    }
}
