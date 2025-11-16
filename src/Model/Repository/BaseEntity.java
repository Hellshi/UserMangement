package Model.Repository;
import java.lang.reflect.Field;

public abstract class BaseEntity<T> {
    @Override
    public String toString() {
        return this.format((T) this);
    }

    public String format(T obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName()).append("{");

        boolean first = true;

        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (!first) sb.append(", ");
                first = false;

                sb.append(field.getName())
                        .append("=")
                        .append("'").append(value).append("'");

            } catch (IllegalAccessException e) {
                System.out.println("Invalid argument");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
