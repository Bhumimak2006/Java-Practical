class MyFileResource implements AutoCloseable {

    public MyFileResource() {
        System.out.println("Resource opened.");
    }

    public void readFile() throws Exception {
        System.out.println("Reading file...");

        throw new Exception("Original error: File data is corrupted.");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource closed automatically.");

        throw new Exception("Error while closing resource.");
    }
}

public class AutoCloseDemo {

    public static void main(String[] args) {

        try (MyFileResource resource = new MyFileResource()) {

            resource.readFile();

        } catch (Exception e) {

            System.out.println("Reported error: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println(
                    "Suppressed error: " + suppressed.getMessage()
                );
            }
        }

        System.out.println("Program continues normally.");
    }
}

