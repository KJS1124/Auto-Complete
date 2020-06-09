package com.psg.autocomplete.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.*;

public class InitEntries {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitEntries.class);
    /**
     * @param stream
     * this method will initialize our basic dictionary
     */
    public static void init(InputStream stream) {
        LOGGER.info("Word List is initializing in memory");
        Trie trie = TrieSingleton.getInstance();
        new BufferedReader(new InputStreamReader(stream)).lines()
                .map(p -> p.toLowerCase().trim())
                .forEach(p -> trie.insert(p));
        LOGGER.info("Word List Initialized");
    }
}
