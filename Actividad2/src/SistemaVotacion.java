import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Voto {
    private String candidato;
    private int id;

    public Voto(String candidato, int id) {
        this.candidato = candidato;
        this.id = id;
    }

    public String getCandidato() {
        return candidato;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return id == voto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class SistemaVotacion {
    private Map<Integer, Voto> votosEmitidos; // Almacena votos únicos por ID
    private Map<String, Integer> escrutinio; // Almacena el conteo de votos por candidato

    public SistemaVotacion() {
        votosEmitidos = new HashMap<>();
        escrutinio = new HashMap<>();
    }

    public void agregarVoto(String candidato, int id) {
        Voto nuevoVoto = new Voto(candidato, id);

        // Verificar si el voto ya fue emitido
        if (votosEmitidos.containsKey(id)) {
            System.out.println("Voto rechazado: El ID " + id + " ya fue utilizado.");
        } else {
            votosEmitidos.put(id, nuevoVoto);

            // Actualizar el escrutinio
            escrutinio.put(candidato, escrutinio.getOrDefault(candidato, 0) + 1);
            System.out.println("Voto registrado: " + candidato + " con ID " + id);
        }
    }

    public void mostrarEscrutinio() {
        System.out.println("\nEscrutinio:");
        for (Map.Entry<String, Integer> entry : escrutinio.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votos");
        }
    }

    public static void main(String[] args) {
        SistemaVotacion sistema = new SistemaVotacion();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Agregar voto");
            System.out.println("2. Mostrar escrutinio");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del candidato: ");
                    String candidato = scanner.nextLine();
                    System.out.print("ID del voto: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    sistema.agregarVoto(candidato, id);
                    break;
                case 2:
                    sistema.mostrarEscrutinio();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}