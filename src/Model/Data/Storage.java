package Model.Data;

import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private final Map<Integer, String> storage = new HashMap<>();

    final String fileName;

    public Storage(String name) {
        this.fileName = name + ".json";
    }

    private void writeToFile() {
        try (FileWriter fw = new FileWriter(this.fileName)) {

            fw.write("{");

            boolean first = true;
            for (Map.Entry<Integer, String> entry : storage.entrySet()) {
                if (!first) fw.write(", ");
                first = false;

                fw.write("\"" + entry.getKey() + "\": " + entry.getValue());
            }

            fw.write("}");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever arquivo JSON: " + e.getMessage());
        }
    }

    public void put(int id, String value) {
        storage.put(id, value);
        writeToFile();
    }

    public String get(int id) {
        return storage.get(id);
    }

    public boolean contains(int id) {
        return storage.containsKey(id);
    }

    public boolean remove(int id) {
        boolean removed = storage.remove(id) != null;
        if (removed) writeToFile();
        return removed;
    }

    public Map<Integer, String> getAll() {
        return storage;
    }
}
