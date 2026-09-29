import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}
class Student {
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

public class ColumnMapper {

    public static Student map(
            String[] headers,
            String[] data) throws Exception {

        Student student = new Student();

        for (Field field :
                Student.class.getDeclaredFields()) {

            if (!field.isAnnotationPresent(Column.class)) {
                continue;
            }

            Column column =
                field.getAnnotation(Column.class);
            String columnName = column.name();

            int index = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(columnName)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println(
                    "Warning: Missing column "
                    + columnName
                );
                continue;
            }
            field.setAccessible(true);
            String value = data[index];

            if (field.getType() == int.class) {

                field.setInt(student,
                    Integer.parseInt(value));

            } else if (field.getType() == String.class) {

                field.set(student, value);
            }
        }

        return student;
    }

    public static void main(String[] args)
            throws Exception {

        String[] headers = {
            "id",
            "name",
            "email"
        };

        String[] data = {
            "101",
            "Bhumi",
            "bhumi@gmail.com"
        };

        Student student =
            map(headers, data);

        System.out.println(student);
    }
}