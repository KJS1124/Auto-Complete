package com.psg.autocomplete.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class InitEntries {

    /**
     * @param stream
     */
    public static void init(InputStream stream) {
        Trie trie = TrieSingleton.getInstance();
        new BufferedReader(new InputStreamReader(stream)).lines()
                .map(p -> p.toLowerCase().trim())
                .forEach(p -> trie.insert(p));
    }
}
