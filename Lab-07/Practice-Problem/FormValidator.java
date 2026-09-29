import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}
class SignupForm {
    @NotBlank
    @MaxLength(20)
    String username;

    @NotBlank
    @MaxLength(50)
    String email;

    @NotBlank
    @MaxLength(15)
    String password;
    SignupForm(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

class Validator {
    public static List<String> validate(Object object) {
        List<String> errors = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (field.isAnnotationPresent(NotBlank.class)) {
                    if (value == null ||
                        value.toString().trim().isEmpty()) {
                        errors.add(
                            field.getName() + " must not be blank."
                        );
                    }
                }
                if (field.isAnnotationPresent(MaxLength.class)
                    && value != null) {
                    MaxLength maxLength =
                        field.getAnnotation(MaxLength.class);
                    int max = maxLength.value();

                    if (value.toString().length() > max) {
                        errors.add(
                            field.getName()
                            + " must have maximum "
                            + max + " characters."
                        );
                    }
                }   
            } catch (IllegalAccessException e) {
                errors.add(
                    "Cannot access field: " + field.getName()
                );
            }
        }

        return errors;
    }
}

public class FormValidator {

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
            "",
            "thisisanextremelylongemailaddress@example.com",
            "password123456789"
        );

        List<String> errors = Validator.validate(form);

        if (errors.isEmpty()) {

            System.out.println("Form is valid.");

        } else {

            System.out.println("Validation errors:");

            for (String error : errors) {
                System.out.println("- " + error);
            }
        }
    }
}