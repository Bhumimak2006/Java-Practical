
public record BankInfo(String name, String branch) {

    public BankInfo {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                "Bank name cannot be empty."
            );
        }

        if (branch == null || branch.isBlank()) {
            throw new IllegalArgumentException(
                "Branch name cannot be empty."
            );
        }
    }
}
