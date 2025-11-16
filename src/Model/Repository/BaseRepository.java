package Model.Repository;

import Model.Data.Storage;

import java.util.Map;

public class BaseRepository<T> {
    private final Storage storage;
    private int nextId = 1;


    public BaseRepository(Storage storage) {
        this.storage = storage;
    }

    public String create(BaseEntity<T> record) {
        int id = nextId++;
        String jsonRecord = record.toString();

        storage.put(id, jsonRecord);

        return jsonRecord;
    }

    public String read(int id) {
        return storage.get(id);
    }

    public boolean update(int id, String newJsonRecord) {
        if (!storage.contains(id)) {
            return false;
        }

        storage.put(id, newJsonRecord);

        return true;
    }

    public boolean delete(int id) {
        return storage.remove(id);
    }

    public String listAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;
        for (Map.Entry<Integer, String> entry : storage.getAll().entrySet()) {
            if (!first) sb.append(", ");
            first = false;

            sb.append("\"")
                    .append(entry.getKey())
                    .append("\": ")
                    .append(entry.getValue());
        }

        sb.append("}");
        return sb.toString();
    }
}
