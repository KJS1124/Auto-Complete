package com.psg.autocomplete.utils;

/**
 * @author Karanjot Singh
 * This class is a implementation to share single instace throughout the application
 */
public class TrieSingleton {
    public static Trie trie;

    private TrieSingleton() {
    }

    /**
     * @return
     *
     */
    public static synchronized Trie getInstance() {
        if (trie == null) trie = new Trie();
        return trie;
    }
}
