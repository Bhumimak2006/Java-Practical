import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {
}
class MyTests {
    @Run
    public void testAddition() {
        System.out.println("testAddition executed");
    }
    @Run
    public void testSubtraction() {
        System.out.println("testSubtraction executed");
    }
    public void normalMethod() {
        System.out.println("normalMethod executed");
    }
    @Run
    public void testMultiplication() {
        System.out.println("testMultiplication executed");
    }
}
public class MiniTestRunner {
    public static void main(String[] args) {
        MyTests testObject = new MyTests();
        int count = 0;
        Method[] methods =
            MyTests.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Run.class)) {
                try {
                    method.invoke(testObject);
                    count++;

                } catch (Exception e) {

                    System.out.println(
                        "Error running: "
                        + method.getName()
                    );
                }
            }
        }
        System.out.println("Total @Run methods executed: " + count);
    }
}