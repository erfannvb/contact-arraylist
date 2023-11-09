package nvb.dev;

public record Contact(
        String name,
        String phoneNumber
) {
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}
