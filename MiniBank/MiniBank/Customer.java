
public class Customer implements Cloneable {

    private final String customerId;
    private String name;
    private String email;
    private String mobile;
    private Address address;

    private static long customerCounter = 100;

    public Customer(String name, String email, String mobile) {
        this.customerId = generateCustomerId();
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    private static String generateCustomerId() {
        return "CUST" + (++customerCounter);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static class Address {

        private String line;
        private String city;
        private String pincode;

        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }

    @Override
    public Customer clone() {
        try {
            Customer copy = (Customer) super.clone();

            if (this.address != null) {
                copy.address = new Address(
                    address.getLine(),
                    address.getCity(),
                    address.getPincode()
                );
            }

            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId
                + " | Name: " + name
                + " | Email: " + email
                + " | Mobile: " + mobile;
    }
}
