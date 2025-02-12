import java.util.*;

class Event {
    private String name;
    private int processingTime;

    public Event(String name, int processingTime) {
        this.name = name;
        this.processingTime = processingTime;
    }

    public String getName() {
        return name;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(name, event.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{" + name + ", " + processingTime + "ms}";
    }
}

class EventManager {
    private Set<Event> events;
    private Queue<Event> eventQueue;
    private List<Event> processedEvents;

    public EventManager() {
        events = new HashSet<>();
        eventQueue = new LinkedList<>();
        processedEvents = new ArrayList<>();
    }

    public void addEvent(String name, int processingTime) {
        Event newEvent = new Event(name, processingTime);
        if (events.add(newEvent)) {
            eventQueue.add(newEvent);
            System.out.println("Evento '" + name + "' agregado con un tiempo de procesado de " + processingTime + "ms.");
        } else {
            System.out.println("El evento '" + name + "' ya existe.");
        }
    }

    public void viewEnqueuedEvents() {
        if (eventQueue.isEmpty()) {
            System.out.println("No hay eventos en cola.");
        } else {
            System.out.println("Eventos encolados:");
            for (Event event : eventQueue) {
                System.out.println(event);
            }
        }
    }

    public void processEvent() {
        if (eventQueue.isEmpty()) {
            System.out.println("No hay eventos para procesar.");
        } else {
            Event event = eventQueue.poll();
            System.out.println("Procesando: " + event.getName());
            System.out.println("Tiempo: " + event.getProcessingTime() + "ms");
            processedEvents.add(event);
        }
    }

    public void viewProcessedEvents() {
        if (processedEvents.isEmpty()) {
            System.out.println("No hay eventos procesados.");
        } else {
            System.out.println("Eventos procesados:");
            for (Event event : processedEvents) {
                System.out.println(event);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Agregar evento");
            System.out.println("2. Ver eventos encolados");
            System.out.println("3. Procesar evento");
            System.out.println("4. Ver eventos procesados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Nuevo evento: ");
                    String name = scanner.nextLine();
                    System.out.print("Tiempo de procesado (ms): ");
                    int time = Integer.parseInt(scanner.nextLine());
                    manager.addEvent(name, time);
                    break;
                case "2":
                    manager.viewEnqueuedEvents();
                    break;
                case "3":
                    manager.processEvent();
                    break;
                case "4":
                    manager.viewProcessedEvents();
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}