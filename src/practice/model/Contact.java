package practice.model;

import java.util.*;

/**
 * Simple Contact object for filling our Phone book.
 */
public class Contact implements Comparable {
    private static final String defaultPhoneNumberType = "Mobile";
    public Contact(String fn, String ln, String company, String email, Map<String, List<String>> phoneNumbers) {
        this.firstName = fn;
        this.lastName = ln;
        this.company = company;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.uuid = UUID.randomUUID();
    }

    public Contact(String fn, String ln, String company, String email, String phoneNumber) {
        this(fn, ln, company, email,  new LinkedHashMap<>());

        this.addPhoneNumber(defaultPhoneNumberType, phoneNumber);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(uuid, contact.uuid);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return this.uuid.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) throw new IllegalArgumentException("Cannot compare incompatible objects");
        Contact contact = (Contact) o;

        if (contact.getLastName() != null && this.getLastName() != null) {
            return this.getLastName().compareTo(contact.getLastName());
        }

        if (contact.getFirstName() != null && this.getFirstName() != null) {
            return this.getFirstName().compareTo(contact.getFirstName());
        }

        if (this.getLastName() != null || this.getFirstName() != null) {
            return 1;
        }
        else {
            return -1;
        }
    }

    private void addPhoneNumber(String phoneNumberType, String phoneNumber) {
        if (!this.phoneNumbers.containsKey(phoneNumberType)) {
            this.phoneNumbers.put(phoneNumberType, new ArrayList<>());
        }
        this.phoneNumbers.get(phoneNumberType).add(phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, List<String>> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<String, List<String>> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    String firstName;
    String lastName;
    Map<String, List<String>> phoneNumbers;
    String company;
    String email;
    UUID uuid;
}
