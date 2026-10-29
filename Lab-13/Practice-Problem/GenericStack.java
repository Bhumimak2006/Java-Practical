import java.util.ArrayList;

class Stack<T> {
    private ArrayList<T> items = new ArrayList<>();
    public void push(T item) {
        items.add(item);
    }
    public T pop() {
        if (items.isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return items.remove(items.size() - 1);
    }
    public T peek() {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(items.size() - 1);
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
}

public class GenericStack {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Top element: " + s.peek());
        System.out.println("Popped: " + s.pop());
        System.out.println("Popped: " + s.pop());
        System.out.println("Is empty: " + s.isEmpty());

        Stack<String> names = new Stack<>();
        names.push("Java");
        names.push("Python");

        System.out.println("String stack top: " + names.peek());
    }
}