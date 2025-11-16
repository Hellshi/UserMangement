package Model.Repository;
import java.util.HashMap;
import java.util.Map;
public class BaseRepository<T> {
    private final Map<Integer, String> storage = new HashMap<>();
    private int nextId = 1;

    String name;

    public BaseRepository(String name) {
        this.name = name;
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
        if (!storage.containsKey(id)) {
            return false;
        }
        storage.put(id, newJsonRecord);
        return true;
    }

    public boolean delete(int id) {
        return storage.remove(id) != null;
    }

    public String listAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean first = true;
        for (Map.Entry<Integer, String> entry : storage.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
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
