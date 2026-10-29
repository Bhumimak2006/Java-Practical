
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) {

        Class<?> cls = BankService.class;

        System.out.println("Class Name: " + cls.getName());

        // Read custom annotation
        BankFeature feature = cls.getAnnotation(BankFeature.class);

        if (feature != null) {
            System.out.println(
                "Bank Feature: " + feature.value()
            );
        }

        // Display methods using Reflection
        System.out.println("\nMethods of BankService:");

        Method[] methods = cls.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
