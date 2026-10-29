class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println(first + " - " + second);
    }
}

public class GenericContainer {

    public static <T> T firstElement(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Integer Box: " + b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Java");
        System.out.println("String Box: " + b2.get());

        Pair<String, Integer> p =
                new Pair<>("Bhumi", 20);

        System.out.print("Pair: ");
        p.display();

        String[] names = {"Riya", "Neha", "Amit"};
        System.out.println("First element: "
                + firstElement(names));

        Integer[] numbers = {10, 20, 30};
        System.out.println("First number: "
                + firstElement(numbers));
    }
}