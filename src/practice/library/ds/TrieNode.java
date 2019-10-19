package practice.library.ds;

import java.util.*;

/**
 * Trie Node to hold data in search efficient format.
 * @param <T>
 */
public class TrieNode<T> {
    public TrieNode(TrieNode parent, int currentIndex) {
        this.children = new TrieNode[26];
        this.parent = parent;
        this.currentIndex = currentIndex;
    }

    public void addChildNode(int index) {
        this.children[index] = new TrieNode(this, index);
    }

    public void removeChildNode(int index) {
        this.children[index] = null;
    }

    public Set<T> getPossibilities(String prefix) {
        return prefix.length() > 0
                ? children[(prefix.charAt(0) - 'a')].getPossibilities(prefix.substring(1))
                : getPossibilities();
    }

    public Set<T> getPossibilities() {
        Set<T> possibleDataItems = new TreeSet<>();
        if (this.data != null) {
            possibleDataItems.addAll(this.data);
        }
        for (int i = 0; i < 26; i++) {
            if (this.children[i] != null) {
                possibleDataItems.addAll(this.children[i].getPossibilities());
            }
        }

        return possibleDataItems;
    }

    public void addDataItem(String prefix, T dataItem) {
        if (prefix.length() > 0) {
            int i = (prefix.charAt(0) - 'a');
            if (this.children[i] == null) {
                this.addChildNode(i);
            }
            this.getChildNode(i).addDataItem(prefix.substring(1), dataItem);
        } else {
            addDataItem(dataItem);
        }
    }

    public boolean removeDataItem(String prefix, T dataItem) {
        if (prefix.length() > 0) {
            int i = (prefix.charAt(0) - 'a');
            if (this.children[i] == null) {
                this.addChildNode(i);
            }
            return this.getChildNode(i).removeDataItem(prefix.substring(1), dataItem);
        }
        else {
            return removeDataItem(dataItem);
        }
    }

    public boolean removeDataItem(T dataItem) {
        if (this.data == null) {
            return false;
        }

        boolean removed = this.data.remove(dataItem);

        if (removed && this.data.size() == 0) {
            this.parent.removeChildNode(this.currentIndex);
        }

        return removed;
    }

    public void addDataItems(String prefix, List<T> dataItems) {
        if (prefix.length() > 0) {
            int i = (prefix.charAt(0) - 'a');
            if (this.children[i] == null) {
                this.addChildNode(i);
            }
            this.getChildNode(i).addDataItems(prefix.substring(1), dataItems);
        } else {
            addDataItems(dataItems);
        }
    }

    public void addDataItem(T dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
    }

    public void addDataItems(List<T> dataItems) {
        if (this.data == null) {
            this.data = dataItems;
        } else {
            this.data.addAll(dataItems);
        }
    }

    public TrieNode getChildNode(int i) {
        return this.children[i];
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "children=" + Arrays.toString(children) +
                ", data=" + data +
                '}';
    }

    TrieNode parent;
    int currentIndex;
    TrieNode[] children;
    List<T> data;
}
