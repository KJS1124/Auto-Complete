package com.psg.autocomplete.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InitEntries {

    /**
     * @throws FileNotFoundException
     */
    public static void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:word");
        Trie trie = TrieSingleton.getInstance();
        try {
            new BufferedReader(new FileReader(file)).lines()
                    .map(p -> p.toLowerCase().trim())
                    .forEach(p -> trie.insert(p));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
