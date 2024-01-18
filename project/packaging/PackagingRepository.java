package project.packaging;

import java.util.ArrayList;
import java.util.List;

public class PackagingRepository {
    private static List<Packaging> repository;
    private static int nextIdPackaging;

    public PackagingRepository() {
        repository = new ArrayList<>();
        nextIdPackaging = 0;
    }

    public static int nextIdPackaging() {
        return nextIdPackaging++;
    }

    public static void savePackaging(Packaging packaging) {
        repository.add(packaging);
    }

    public static void updatePackaging(int id, String change, String newchange) {
        if (!repository.contains(repository.get(id))) {
            throw new IllegalAccessError("Packaging not found");
        }
        Packaging packaging = repository.get(id);
        packaging.updatePackaging(change, newchange);
    }

    public static Packaging getPackagingById(int id) {
        return repository.get(id);
    }

    public static String getAllPackagings() {
        String result="";
        for (Packaging packaging : repository) {
            result += packaging.toString()+"\n";
        }
        return result;
    }

    public static void deletePackaging(int id) {
        repository.remove(id);
    }
}
