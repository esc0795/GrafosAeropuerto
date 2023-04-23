import java.util.*;

public class GrafoAeropuertos {
    private Map<String, List<Conexion>> grafo;

    public GrafoAeropuertos() {
        this.grafo = new HashMap<>();
    }

    public void agregarAeropuerto(String aeropuerto) {
        if (!grafo.containsKey(aeropuerto)) {
            grafo.put(aeropuerto, new ArrayList<>());
        }
    }

    public void agregarConexion(String aeropuerto1, String aeropuerto2, int distancia) {
        agregarAeropuerto(aeropuerto1);
        agregarAeropuerto(aeropuerto2);
        grafo.get(aeropuerto1).add(new Conexion(aeropuerto2, distancia));
        grafo.get(aeropuerto2).add(new Conexion(aeropuerto1, distancia));
    }

    public int obtenerDistancia(String aeropuerto1, String aeropuerto2) {
        if (!grafo.containsKey(aeropuerto1) || !grafo.containsKey(aeropuerto2)) {
            return -1; // Uno de los aeropuertos no existe en el grafo
        }
        Queue<String> cola = new LinkedList<>();
        Map<String, Integer> distancia = new HashMap<>();
        for (String aeropuerto : grafo.keySet()) {
            distancia.put(aeropuerto, Integer.MAX_VALUE);
        }
        distancia.put(aeropuerto1, 0);
        cola.add(aeropuerto1);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            for (Conexion conexion : grafo.get(actual)) {
                int nuevaDistancia = distancia.get(actual) + conexion.distancia;
                if (nuevaDistancia < distancia.get(conexion.aeropuerto)) {
                    distancia.put(conexion.aeropuerto, nuevaDistancia);
                    cola.add(conexion.aeropuerto);
                }
            }
        }
        return distancia.get(aeropuerto2) == Integer.MAX_VALUE ? -1 : distancia.get(aeropuerto2);
    }

    public boolean tienenConexion(String aeropuerto1, String aeropuerto2) {
        if (!grafo.containsKey(aeropuerto1) || !grafo.containsKey(aeropuerto2)) {
            return false; // Uno de los aeropuertos no existe en el grafo
        }
        Set<String> visitados = new HashSet<>();
        visitados.add(aeropuerto1);
        Queue<String> cola = new LinkedList<>();
        cola.add(aeropuerto1);
        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (actual.equals(aeropuerto2)) {
                return true;
            }
            for (Conexion conexion : grafo.get(actual)) {
                if (!visitados.contains(conexion.aeropuerto)) {
                    visitados.add(conexion.aeropuerto);
                    cola.add(conexion.aeropuerto);
                }
            }
        }
        return false; // No hay camino entre los dos aeropuertos
    }

    private static class Conexion {
        private String aeropuerto;
        private int distancia;

        public Conexion(String aeropuerto, int distancia) {
            this.aeropuerto = aeropuerto;
            this.distancia = distancia;
        }
    }
}

