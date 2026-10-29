import java.io.*;

class Student implements Serializable {
    private int rollNo;
    private String name;

    private transient int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}

public class SerializationDemo {
    public static void main(String[] args) {

        Student[] students = {
            new Student(101, "Bhumi", 85),
            new Student(102, "Riya", 90),
            new Student(103, "Neha", 88)
        };

        try {
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("students.dat"));

            out.writeObject(students);
            out.close();

            System.out.println("Objects saved successfully.\n");
        }
        catch (IOException e) {
            System.out.println("Error while saving: " + e);
        }

        try {
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("students.dat"));

            Student[] loadedStudents = (Student[]) in.readObject();
            in.close();

            System.out.println("Objects loaded successfully.\n");

            for (Student s : loadedStudents) {
                s.display();
                System.out.println();
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error while loading: " + e);
        }
    }
}