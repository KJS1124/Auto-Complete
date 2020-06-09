package com.psg.autocomplete.utils;

/**
 * @author Karanjot Singh
 */
public class TrieSingleton {
    public static Trie trie;

    private TrieSingleton() {
    }

    /**
     * @return
     */
    public static synchronized Trie getInstance() {
        if (trie == null) trie = new Trie();
        return trie;
    }
}
