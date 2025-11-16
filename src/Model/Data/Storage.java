package Model.Data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<Integer, String> storage = new HashMap<>();
    private final String directoryPath;
    final String fileName;

    public Storage(String name) {
        this.directoryPath = "src/Model/DB";
        this.fileName = this.directoryPath + "/" + name + ".json";

        File dir = new File(directoryPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
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
