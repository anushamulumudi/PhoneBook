package practice.library.ds;

import java.util.List;
import java.util.Set;

/**
 * Trie to hold the root Trie node and expose useful functionality as a library.
 * All the prefixes are first sanitized to contain only lower case letters and alphabets.
 * @param <T>
 */
public class Trie<T> {
    public Trie() {
        this.root  = new TrieNode<>(null, 0);
    }

    public void removeDataItem(String prefix, T dataItem) {
        this.root.addDataItem(sanitizePrefix(prefix), dataItem);
    }

    public void addDataItem(String prefix, T dataItem) {
        this.root.addDataItem(sanitizePrefix(prefix), dataItem);
    }

    public void addDataItems(String prefix, List<T> dataItems) {
        this.root.addDataItems(sanitizePrefix(prefix), dataItems);
    }

    public Set<T> getPossibilities(String prefix) {
        return this.root.getPossibilities(sanitizePrefix(prefix));
    }

    /**
     * This trie is only based on lower case characters.
     */
    private String sanitizePrefix(String prefix) {
        if (prefix == null) {
            return "";
        }

        StringBuilder sanitizedPrefix = new StringBuilder(prefix.length());
        prefix = prefix.toLowerCase();
        for (int i = 0; i < prefix.length(); i++) {
            char charAtI = prefix.charAt(i);
            int characterSetIndex = charAtI - 'a';
            if (characterSetIndex >= 0 && characterSetIndex <= 25) {
                sanitizedPrefix.append(charAtI);
            }
        }

        return sanitizedPrefix.toString();
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    TrieNode<T> root;
}
