package practice.app;

import practice.model.Contact;

/**
 * Test usages for PhoneBook class.
 */
public class PhoneBookApp {
    public static void main(String[] args) {
        Contact a = new Contact("Anusha", "Mulumudi", "AirBnB",
                "anusha.mulumudi@gmail.com", "254 400 4182");
        Contact b = new Contact("John", "Doe", "Facebook",
                "John.doe@gmail.com", "254 400 2423");
        Contact c = new Contact("Lady", "Gaga", null,
                "lady.gaga@gmail.com", "254 400 2344");
        Contact d = new Contact("Aaron", "Sorkin", "Author",
                "aaron.sorkin@gmail.com", "254 400 5677");
        Contact e = new Contact("Adam", "Grant", "Writer",
                "adam.grant@gmail.com", "254 400 4567");
        Contact f = new Contact("Obama", "Barack", "President",
                "barack.obama@gmail.com", "254 400 2354");
        Contact g = new Contact("Agatha", "Christie", "Author",
                "Agatha.Christie@gmail.com", "254 400 1243");
        Contact h = new Contact("Lindsay", "Allen", null,
                "lindsay.allen@gmail.com", "254 400 6543");

        PhoneBook book = new PhoneBook();

        book.addContact(a);
        book.addContact(b);
        book.addContact(c);
        book.addContact(d);
        book.addContact(e);
        book.addContact(f);
        book.addContact(g);
        book.addContact(h);

        book.printPhoneBook();

        book.removeContact(d);

        book.printPhoneBook();

        System.out.println("Printing all the contacts that starts with a in either first name or last name sorted by last name : ");
        for (Contact contact :  book.searchContacts("a")) {
            System.out.println(contact);
        }
    }


}
