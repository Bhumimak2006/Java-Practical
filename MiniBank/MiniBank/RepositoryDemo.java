
public class RepositoryDemo {

    static class CustomerRecord {

        @Id
        private final String customerId;

        private final String name;

        public CustomerRecord(String customerId, String name) {
            this.customerId = customerId;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer ID: " + customerId
                    + ", Name: " + name;
        }
    }

    public static void main(String[] args) {

        Repository<CustomerRecord> repository =
            new Repository<>();

        CustomerRecord c1 =
            new CustomerRecord("C101", "Rahul");

        CustomerRecord c2 =
            new CustomerRecord("C102", "Priya");

        repository.save(c1);
        repository.save(c2);

        System.out.println("Find Customer:");

        System.out.println(repository.findById("C101"));

        System.out.println("\nAll Customers:");

        for (CustomerRecord customer :
                repository.findAll().values()) {
            System.out.println(customer);
        }

        repository.deleteById("C101");

        System.out.println("\nAfter Deletion:");
        System.out.println(repository.findById("C101"));
    }
}
