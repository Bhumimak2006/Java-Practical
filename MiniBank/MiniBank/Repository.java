
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Repository<T> {

    private final Map<Object, T> data = new HashMap<>();

    // Save an object using its @Id field
    public void save(T object) {

        if (object == null) {
            throw new IllegalArgumentException(
                "Object cannot be null."
            );
        }

        try {
            Field idField = findIdField(object.getClass());

            if (idField == null) {
                throw new IllegalArgumentException(
                    "No @Id field found."
                );
            }

            idField.setAccessible(true);
            Object id = idField.get(object);

            if (id == null) {
                throw new IllegalArgumentException(
                    "ID cannot be null."
                );
            }

            data.put(id, object);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(
                "Unable to read object ID.", e
            );
        }
    }

    // Find an object using its ID
    public T findById(Object id) {
        return data.get(id);
    }

    // Delete an object using its ID
    public void deleteById(Object id) {
        data.remove(id);
    }

    // Return all saved objects
    public Map<Object, T> findAll() {
        return new HashMap<>(data);
    }

    // Find the field marked with @Id
    private Field findIdField(Class<?> type) {

        Class<?> current = type;

        while (current != null) {
            for (Field field : current.getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class)) {
                    return field;
                }
            }

            current = current.getSuperclass();
        }

        return null;
    }
}
