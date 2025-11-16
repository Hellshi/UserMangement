package Model.Repository;
import java.lang.reflect.Field;

public abstract class BaseEntity<T> {
    @Override
    public String toString() {
        return this.format();
    }

    public String format() {
        try {
            Class<?> clazz = this.getClass();
            Field[] fields = clazz.getDeclaredFields();

            StringBuilder sb = new StringBuilder();
            sb.append("{");

            boolean first = true;

            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(this);

                if (!first) sb.append(", ");
                first = false;

                sb.append("\"")
                        .append(field.getName())
                        .append("\": ");

                if (value == null) {
                    sb.append("null");
                } else if (value instanceof Number || value instanceof Boolean) {
                    sb.append(value);
                } else {
                    sb.append("\"").append(value).append("\"");
                }
            }

            sb.append("}");
            return sb.toString();

        } catch (Exception e) {
            return "{}";
        }
    }
}
