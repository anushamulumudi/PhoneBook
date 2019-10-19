package practice.app;

import practice.library.ds.Trie;
import practice.model.Contact;

import java.util.Set;

/**
 * Phonebook class that holds information in a search efficient Trie to be able to do fast searches with prefixes.
 */
public class PhoneBook {
    public PhoneBook() {
        this.nameTrie = new Trie<>();
    }

    public void addContact(Contact contact) {
        if (contact.getLastName() != null && !"".equals(contact.getLastName())) {
            this.nameTrie.addDataItem(contact.getLastName(), contact);
        }

        if (contact.getFirstName() != null && !"".equals(contact.getFirstName())) {
            this.nameTrie.addDataItem(contact.getFirstName(), contact);
        }
    }

    public void removeContact(Contact contact) {
        if (contact.getUuid() == null) {
            throw new IllegalArgumentException("Please copy the UUID from the existing Contact object that you would" +
                    " like to delete");
        }

        if (contact.getLastName() != null && !"".equals(contact.getLastName())) {
            this.nameTrie.removeDataItem(contact.getLastName(), contact);
        }

        if (contact.getFirstName() != null && !"".equals(contact.getFirstName())) {
            this.nameTrie.removeDataItem(contact.getFirstName(), contact);
        }
    }

    public Set<Contact> searchContacts(String prefix) {
        return this.nameTrie.getPossibilities(prefix);
    }

    public void printPhoneBook() {
        System.out.println(nameTrie);
    }

    Trie<Contact> nameTrie;
}
