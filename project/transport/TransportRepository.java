package project.transport;

import java.util.List;
import java.util.ArrayList;
public class TransportRepository {
    private static List<Transport> repository=new ArrayList<Transport>();
    private static int nextIdTransport;

    public TransportRepository() {
        repository = new ArrayList<>();
        nextIdTransport = 0;
    }

    public static int nextIdTransport() {
        return nextIdTransport++;
    }

    public static void saveTransport(Transport transport) {
        repository.add(transport);
    }

    public static void updateTransport(int id, String change, String newchange) {
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Transport not found");
        }
        Transport transport = repository.get(id);
        transport.updateTransport(id,change, newchange);
    }

    public static Transport getTransportById(int id) {
        return repository.get(id);
    }

    public static String getAllTransports() {
        String result="";
        for (Transport transport : repository) {
            result += transport.toString() + "\n";
        }
        return result;
    }

    public static void deleteTransport(int id) {
        repository.remove(id);
    }
}
